import json
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
README = os.path.join(ROOT, "README.md")
TOPICS_FILE = os.path.join(ROOT, "topics.json")
START = "<!-- TOPICS:START -->"
END = "<!-- TOPICS:END -->"

IGNORE = {".git", ".github", "scripts", "node_modules"}
FOLDER_RE = re.compile(r"^(\d+)-(.+)$")

TOPIC_ORDER = [
    "Arrays & Strings", "Two Pointers", "Sliding Window", "Linked List",
    "Stack", "Binary Search", "Trees / BST", "Tries", "Heap / Priority Queue",
    "Backtracking", "Graphs", "DP / Greedy", "Hashing", "Math", "Uncategorized"
]


ACRONYMS = {"bst", "ii", "iii", "iv", "gcd", "lcm", "dp"}


def title_from_slug(slug):
    words = slug.split("-")
    return " ".join(w.upper() if w in ACRONYMS else w.capitalize() for w in words)


def scan_folders():
    return sorted(
        d for d in os.listdir(ROOT)
        if os.path.isdir(os.path.join(ROOT, d)) and not d.startswith(".") and d not in IGNORE
        and FOLDER_RE.match(d)
    )


def build_table():
    topics = json.load(open(TOPICS_FILE)) if os.path.exists(TOPICS_FILE) else {}
    folders = scan_folders()
    grouped = {}
    for folder in folders:
        num, slug = FOLDER_RE.match(folder).groups()
        topic = topics.get(folder, "Uncategorized")
        grouped.setdefault(topic, []).append((int(num), folder, title_from_slug(slug)))

    lines = [f"Total solved: {len(folders)}", ""]
    for topic in TOPIC_ORDER:
        if topic not in grouped:
            continue
        lines.append(f"## {topic}")
        for num, folder, title in sorted(grouped[topic]):
            lines.append(f"- [{num}. {title}](./{folder})")
        lines.append("")
    return "\n".join(lines).rstrip() + "\n"


def update_readme():
    content = open(README).read() if os.path.exists(README) else f"# DSA\n\n{START}\n{END}\n"
    table = build_table()
    pattern = re.compile(re.escape(START) + r".*" + re.escape(END), re.DOTALL)
    replacement = f"{START}\n{table}{END}"
    if pattern.search(content):
        content = pattern.sub(replacement, content)
    else:
        content = content.rstrip() + f"\n\n{replacement}\n"
    open(README, "w").write(content)


if __name__ == "__main__":
    update_readme()
