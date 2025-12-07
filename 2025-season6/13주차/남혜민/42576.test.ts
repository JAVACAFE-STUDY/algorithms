import * as assert from 'assert';
import { test } from 'node:test';
import { solution } from './42576';

test('example 1', () => {
    const participant = ["leo", "kiki", "eden"];
    const completion = ["eden", "kiki"];
    const result = solution(participant, completion);
    assert.strictEqual(result, "leo");
});

test('example 2', () => {
    const participant = ["marina", "josipa", "nikola", "vinko", "filipa"];
    const completion = ["josipa", "filipa", "marina", "nikola"];
    const result = solution(participant, completion);
    assert.strictEqual(result, "vinko");
});

test('example 3 - duplicate names', () => {
    const participant = ["mislav", "stanko", "mislav", "ana"];
    const completion = ["stanko", "ana", "mislav"];
    const result = solution(participant, completion);
    assert.strictEqual(result, "mislav");
});
