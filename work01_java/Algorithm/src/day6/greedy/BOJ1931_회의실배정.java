package day6.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Meeting o) {
		return this.end != o.end ? this.end - o.end : this.start - o.start;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meeting [start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
	}
}
public class BOJ1931_회의실배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Meeting> mt = new ArrayList();
		ArrayList<Meeting> result = new ArrayList();
		int count = 0;
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			mt.add(new Meeting(start, end));
		}
		
		Collections.sort(mt);
//		System.out.println(mt.toString());
		result.add(mt.get(0));
		count++;
		for (int i = 1; i < N; i++) {
			if (result.get(count - 1).end <= mt.get(i).start) {
				result.add(mt.get(i));
				count++;
			}
		}
		System.out.println(count);
	}

}
