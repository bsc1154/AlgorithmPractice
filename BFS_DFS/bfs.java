package com.company;

import java.util.LinkedList;
import java.util.Queue;
//프로그래머스 - 게임 맵 최단거리
public class bfs {
    int[] dx = {0, 0, 1, -1};//동서
    int[] dy = {-1, 1, 0, 0};//남북
    public static void main(String args[]){
    }

    public int solution(int [][] maps){
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        visited[0][0] = 1;

        bfs(maps, visited);

        answer = visited[maps.length-1][maps[0].length-1];//마지막위치가 누적된 방문 횟수

        if(answer == 0 ){
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][]maps, int[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int [] now = q.poll();
            //현재 위치 x, y 좌표
            int x = now[0];
            int y = now[1];

            for(int i=0; i< 4; i++){
                //동서남북 탐색하며
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1){
                //이동할 지점이 맵의 처음 부터 끝이면서, 방문은 안했으면서, 방문이 가능한 지점
                    visited[nx][ny] = visited[x][y] + 1;//방문 지점 = 해당위치까지 방문한 수 + 1
                    q.add(new int[]{nx, ny});//큐에 현재지점 넣기
                }
            }
        }
    }
}
