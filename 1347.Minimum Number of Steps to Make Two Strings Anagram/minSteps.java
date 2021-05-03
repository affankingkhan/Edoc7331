class Solution {
    public int minSteps(String s, String t) {
        
        int[] arr = new int[26];

		for (char c : s.toCharArray()) {
			arr[c - 'a'] = arr[c - 'a'] + 1;
		}

		for (char c : t.toCharArray()) {
			if (arr[c - 'a'] > 0)
				arr[c - 'a'] = arr[c - 'a'] - 1;
		}

		int rtn = 0;
		for (int i : arr) {
			if (i > 0) {
				rtn = rtn + i;
			}
		}

		return rtn;
    }

    /// solution 2 

  //   int[] arr = new int[26];

		// for (char c : s.toCharArray()) {
		// 	arr[c - 'a'] = arr[c - 'a'] + 1;
		// }

		// for (char c : t.toCharArray()) {
  //           arr[c - 'a'] = arr[c - 'a'] - 1;
		// }

		// int rtn = 0;
		// for (int i : arr) {
		// 	rtn += Math.abs(i);
		// }

		// return rtn / 2 ;
}