class Solution {
    public String capitalizeTitle(String title) {

        char[] chars = title.toCharArray();
        int len = chars.length;
        int i = 0;

        while (i < len) {
            int start = i;

            while (i < len && chars[i] != ' ') {
                chars[i] = Character.toLowerCase(chars[i]);
                i++;
            }

            if ((i - start) > 2) {
                chars[start] = Character.toUpperCase(chars[start]);
            }

            i++;
        }

        return new String(chars);
    }
}