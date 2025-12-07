/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 문제: 마라톤 참가자 배열과 완주자 배열이 주어질 때, 완주하지 못한 선수 1명을 찾기
 * 제약: 동명이인 가능, participant 길이 = completion 길이 + 1
 * 접근: 해시맵으로 참가자 카운트 저장 후 완주자 카운트 차감, 남은 선수 반환
 */

// n : participant 길이, m: completion 길이 (n-1)
// 시간복잡도: O(n + n - 1 + n) =O (3n - 1) - participant, completion 두 배열을 순회 + 맵 순회 ->  O(n)
export function solution(participant: string[], completion: string[]): string {
    const map = new Map<string, number>(); // 해시맵

    for (const name of participant) {
        // O(n) - participant 배열 순회
        map.set(name, (map.get(name) || 0) + 1);
    }
    for (const name of completion) {
        // O(m) - completion 배열 순회, m = n-1
        map.set(name, map.get(name)! - 1);
    }

    for (const [name, count] of map) {
        // O(n) - 맵 순회 (최악의 경우 모든 참가자)
        if (count > 0) {
            return name;
        }
    }
    return '';
}
