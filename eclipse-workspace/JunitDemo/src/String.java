public class String {
    private char[] data;

    public String(String str) {
        if (str == null) {
            this.data = new char[0];
        } else {
            this.data = str.toCharArray();
        }
    }

    public int length() {
        return data.length;
    }

    public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > data.length) {
            endIndex = data.length;
        }
        if (beginIndex > endIndex) {
            return "";
        }
        return new String(data, beginIndex, endIndex - beginIndex);
    }

    public boolean contains(CharSequence sequence) {
        return indexOf(sequence.toString()) >= 0;
    }

    public int indexOf(String str) {
        for (int i = 0; i <= data.length - str.length(); i++) {
            boolean found = true;
            for (int j = 0; j < str.length(); j++) {
                if (data[i + j] != str.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HomemadeString other = (HomemadeString) obj;
        return new String(data).equals(new String(other.data));
    }

    public String replace(CharSequence target, CharSequence replacement) {
        String targetStr = target.toString();
        String replacementStr = replacement.toString();
        String originalStr = new String(data);
        String newStr = originalStr.replace(targetStr, replacementStr);
        return new HomemadeString(newStr);
    }

    public String toLowerCase() {
        String originalStr = new String(data);
        String lowerCaseStr = originalStr.toLowerCase();
        return new HomemadeString(lowerCaseStr);
    }

    public String toUpperCase() {
        String originalStr = new String(data);
        String upperCaseStr = originalStr.toUpperCase();
        return new HomemadeString(upperCaseStr);
    }

    public String trim() {
        String originalStr = new String(data);
        String trimmedStr = originalStr.trim();
        return new HomemadeString(trimmedStr);
    }

    public boolean startsWith(String prefix) {
        return new String(data).startsWith(prefix);
    }
}
