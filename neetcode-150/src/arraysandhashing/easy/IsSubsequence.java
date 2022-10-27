package arraysandhashing.easy;

import java.util.Objects;

public class IsSubsequence {

    class Recursive {

        private String source;
        private String target;

        public boolean isSubsequence(String s, String t) {

            source = s;
            target = t;

            return recursiveSearch(0, 0);
        }

        private boolean recursiveSearch(int sIndex, int tIndex) {

            /*
                 if end of source string is reached
                 target length doesn't matter
                 source is a subsequence of target
            */
            if (sIndex == source.length()) return true;

            /*
                code reaches this line if source end is not reached
                but target end is reached
                in this case source is NOT a subsequence of target
            */
            if (tIndex == target.length()) return false;

            // If current source character matches current target character
            if (source.charAt(sIndex) == target.charAt(tIndex)) {
                // try to match next char of s
                // with next char of t
                return recursiveSearch(sIndex + 1, tIndex + 1);
            } else {
                // try to match current char of s
                // with next char of t
                return recursiveSearch(sIndex, tIndex + 1);
            }

        }

    }

    class TwoPointer {
        public boolean isSubsequence(String s, String t) {

            if (s.isEmpty()) return true;
            if (s.length() > t.length()) return false;
            if (s.length() == t.length()) return Objects.equals(s, t);

            int index = 0;
            char cs = s.charAt(index);

            for (char ct : t.toCharArray()) {
                if (cs == ct) {
                    index++;
                    if (index != s.length()) {
                        cs = s.charAt(index);
                    }
                }
            }

            return index == s.length();

        }
    }
}
