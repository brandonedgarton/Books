public class HomemadeString {
    private char[] data;

    public HomemadeString(String str) {
        if (str == null) {
            this.data = new char[0];
        } else {
            this.data = str.toCharArray();
        }
    }

    public int length() {
        return data.length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public HomemadeString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > data.length) {
            endIndex = data.length;
        }
        if (beginIndex > endIndex) {
            return new HomemadeString("");
        }
        char[] subData = new char[endIndex - beginIndex];
        System.arraycopy(data, beginIndex, subData, 0, endIndex - beginIndex);
        return new HomemadeString(new String(subData));
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
        if (data.length != other.data.length) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != other.data[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(HomemadeString other) {
        if (data.length != other.data.length) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            char thisChar = Character.toLowerCase(data[i]);
            char otherChar = Character.toLowerCase(other.data[i]);
            if (thisChar != otherChar) {
                return false;
            }
        }
        return true;
    }

    public HomemadeString toUpperCase() {
        char[] upperCaseData = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            upperCaseData[i] = Character.toUpperCase(data[i]);
        }
        return new HomemadeString(new String(upperCaseData));
    }

    public HomemadeString toLowerCase() {
        char[] lowerCaseData = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            lowerCaseData[i] = Character.toLowerCase(data[i]);
        }
        return new HomemadeString(new String(lowerCaseData));
    }

}
