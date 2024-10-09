import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int x, y;  // 현재 노드의 좌표
    int cost;  // 시작점에서 현재 노드까지의 총 비용
    int heuristic;  // 현재 노드에서 목적지까지의 예상 비용

    public Node(int x, int y, int cost, int heuristic) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    // PriorityQueue에서 우선순위를 정하기 위한 메서드
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost + this.heuristic, other.cost + other.heuristic);
    }
}

public class AStar {
    // 이동 가능한 방향 (상, 하, 좌, 우, 대각선)
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<int[]> findPath(int[][] grid, int[] start, int[] goal) {
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        openSet.add(new Node(start[0], start[1], 0, heuristic(start, goal))); // 초기화: 시작 노드 초기화

        // 이전 노드를 저장하기 위한 배열
        Node[][] cameFrom = new Node[rows][cols];

        // 초기화: 시작점에서 각 노드까지의 최소 비용을 저장하는 배열
        int[][] costSoFar = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                costSoFar[i][j] = Integer.MAX_VALUE;
            }
        }
        costSoFar[start[0]][start[1]] = 0;

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.x == goal[0] && current.y == goal[1]) {
                // 목적지에 도달했을 경우 경로를 복원(복기)
                return reconstructPath(cameFrom, goal);
            }

            for (int[] direction : DIRECTIONS) {
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && grid[nextX][nextY] == 0) {
                    int newCost = current.cost + 1;

                    if (newCost < costSoFar[nextX][nextY]) { // 갱신: 이 때 휴리스틱은 연관x(휴리스틱은 우선순위 큐 조정에만 도움을 줌.)
                        costSoFar[nextX][nextY] = newCost;
                        Node neighbor = new Node(nextX, nextY, newCost, heuristic(new int[]{nextX, nextY}, goal));
                        openSet.add(neighbor);
                        cameFrom[nextX][nextY] = current;
                    }
                }
            }
        }

        // 경로가 없는 경우
        return Collections.emptyList();
    }

    private static int heuristic(int[] a, int[] b) {
        // 휴리스틱 함수 (예상 비용) - 여기서는 맨해튼 거리 사용
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private static List<int[]> reconstructPath(Node[][] cameFrom, int[] goal) {
        List<int[]> path = new ArrayList<>();
        Node current = new Node(goal[0], goal[1], 0, 0);

        while (current != null) {
            path.add(new int[]{current.x, current.y});
            current = cameFrom[current.x][current.y];
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 0};
        int[] goal = {4, 4};

        List<int[]> path = findPath(grid, start, goal);

        if (!path.isEmpty()) {
            for (int[] point : path) {
                System.out.println("(" + point[0] + ", " + point[1] + ")");
            }
        } else {
            System.out.println("경로가 없습니다.");
        }
    }
}