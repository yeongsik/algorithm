package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Section5_8 {
    static class Patient implements Comparable<Patient> {
        private int number;
        private int risk;

        public Patient(int number, int risk) {
            this.number = number;
            this.risk = risk;
        }

        @Override
        public int compareTo(Patient o) {
            if (this.risk == o.risk) {
                return this.number > o.number ? 1 : -1;
            }
            return this.risk > o.risk ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Patient> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Patient(i, Integer.parseInt(st.nextToken())));
        }

        int idx = 1;
        while (!pq.isEmpty()) {
            Patient curPatient = pq.poll();
            if (curPatient.number == m) {
                System.out.println(idx);
            }
            idx++;
        }
    }
}
