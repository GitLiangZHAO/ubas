package sample;

public class Solution {

	public int solution(IntList L) {
		// write your code in Java SE 8  liang's change
		if (L.next == null) {
			return 1;
		}
		return solution(L.next) + 1;
	}

	int solution(int[] A) {
		int n = A.length;
		int[] L = new int[n + 1];
		L[0] = -1;
		for (int i = 0; i < n; i++) {
			L[i + 1] = A[i];
		}
		int count = 0;
		int pos = (n + 1) / 2;
		int candidate = L[pos];
		for (int i = 1; i <= n; i++) {
			if (L[i] == candidate)
				count = count + 1;
		}
		if (count > pos)
			return candidate;
		return (-1);
	}

}
