class MergeSortString{
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
       return mergeSort(s).equals(mergeSort(t));
    }

    private static String mergeSort(String str){
        if(str.length() == 1){
            return str;
        }
        int mid = str.length() /2;
        String left = mergeSort(str.substring(0,mid));
        String right = mergeSort(str.substring(mid,str.length()));

        return merge(left,right);
    }

    private static String merge(String first, String second){
        StringBuilder answer = new StringBuilder();
        int i = 0, j = 0;

        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) < second.charAt(j)) {
                answer.append(first.charAt(i));
                i++;
            } else {
                answer.append(second.charAt(j));
                j++;
            }
        }

        while (i < first.length()) {
            answer.append(first.charAt(i));
            i++;
        }

        while (j < second.length()) {
            answer.append(second.charAt(j));
            j++;
        }

        return answer.toString();
    }
}