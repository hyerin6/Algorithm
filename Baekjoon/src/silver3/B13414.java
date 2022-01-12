package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B13414 {
	static int K, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		Set<String> hs = new LinkedHashSet<>();
		String tmp;
		for (int i = 0; i < L; ++i) {
			tmp = br.readLine();
			if (hs.contains(tmp)) {
				hs.remove(tmp);
			}
			hs.add(tmp);
		}

		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			if (--K < 1)
				break;
		}

	}
}
