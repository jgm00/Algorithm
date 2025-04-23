import java.io.*;
import java.util.*;

public class Main {
	static int N;

	static class Person implements Comparable<Person> {
		int idx;
		int age;
		String name;

		Person(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o1) {
			if (this.age == o1.age) {
				return this.idx - o1.idx;
			}
			return this.age - o1.age;
		}
	}

	static Person[] p;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new Person[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			p[i] = new Person(i, a, b);
		}
		Arrays.sort(p);
		for (int i = 0; i < N; i++) {
			System.out.println(p[i].age + " " + p[i].name);
		}
	}
}