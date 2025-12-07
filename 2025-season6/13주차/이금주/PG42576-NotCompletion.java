import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
         Map<String, Integer> map = new HashMap<>(); // TC: O(1), SC: O(n)
        
         // participant의 이름 횟수 세기
        for(String name :participant){ // TC: O(n), SC: O(1)
            map.put(name, map.getOrDefault(name, 0) + 1); // TC: O(1), SC: O(1)
        }
        
         // completion을 보면서 횟수 빼기
         for (String name : completion) { //TC: O(n-1),SC: O(1) 
             // 완주한 사람의 횟수를 1 감소
            map.put(name, map.get(name) - 1); // TC: O(1), SC: O(1)
        }
        
         // 횟수가 1인 사람 찾기 (완주 못한 사람)
        for (String name : map.keySet()) {  // TC: O(n), SC: O(1)
            // 횟수가 1이면 완주하지 못한 사람!
            if (map.get(name) == 1) {// TC: O(1), SC: O(1)
                return name; // TC: O(1), SC: O(1) 
            }
        }
         return "";
    }
}

/*
================= 시간 복잡도 ===============
**변수 정의**
n: participant.length (참가자 수)
m: completion.length = n - 1 (완주자 수)
u: 고유한 이름 개수 (1 ≤ u ≤ n)

1. HashMap 생성:        O(1)
2. participant 순회:    O(n)
   - n번 반복
   - 각 put/get:        O(1)
3. completion 순회:     O(m) = O(n-1) ≈ O(n)
   - m번 반복
   - 각 put/get:        O(1)
4. map.keySet() 순회:   O(u) ≤ O(n)
   - u = 고유 이름 개수
   - 최악: u = n
   - 각 get:            O(1)

전체 = O(1) + O(n) + O(n) + O(n)
     = O(3n + 1)
     = O(n)

================= 공간 복잡도 =============== 
1. HashMap (map):       O(u) ≤ O(n)
   - 최악: 모든 이름이 고유 → u = n
   - 최선: 모든 이름이 같음 → u = 1
   
2. 반복문 변수들:       O(1)
   - name (String 참조)
   
3. 총합:  O(n) + O(1) = O(n)
*/
