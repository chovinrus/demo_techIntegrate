package demo.zjm.ds.graph;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: demo_techIntegrate
 * @ClassName: 迪杰斯特拉算法
 * @description:
 * @author: AlanMa
 * @create: 2024-11-04 14:57
 */

@Data
class Graph {
    private int V_count;
    private int[][] matrix;

    public Graph(int v_count, int[][] matrix) {
        V_count = v_count;
        this.matrix = matrix;
    }

    /*
     * 迪杰斯特拉算法
     * @param start
     * @return java.util.List<java.lang.Integer> 最短路径
     * @author 26973
     * @date 2024/11/4 15:18
     **/
    public Map<Integer[], List<Integer>> getShortestPath(int start) {
        // dist存储每个节点的最短距离，preVector存储每个节点的前驱节点（通过类似于静态链表的形式来描述路径）
        List<Integer> dist = Stream.generate(() -> Integer.MAX_VALUE).limit(V_count).collect(Collectors.toList());
        List<Integer> preVector = Stream.generate(() -> 0).limit(V_count).collect(Collectors.toList());
        // resultMap的键integers[0]是节点，integers[1]是距离，值List<Integer>是路径
        Map<Integer[], List<Integer>> resultMap = new HashMap<>();

        // visited记录各节点是否被计算过
        List<Boolean> visited = Stream.generate(() -> false).limit(V_count).collect(Collectors.toList());

        // 初始化源点
        dist.set(start, 0);
        preVector.set(start, start);

        // 所有节点都被计算过
        while (visited.stream().filter(item -> !item).collect(Collectors.toList()).size() > 0) {
            // 从未计算过的节点中找到当前最小距离的节点
            int minIndex = 0, min = Integer.MAX_VALUE;
            for (int i = 1; i < V_count; i++) {
                if (!visited.get(i) && dist.get(i) < min) {
                    minIndex = i;
                    min = dist.get(i);
                }
            }
            // 标记该节点已被计算过
            visited.set(minIndex, true);
            // 更新该节点的出边邻居节点的距离dist，并更新前驱节点
            for (int i = 0; i < V_count; i++) {
                if (matrix[minIndex][i] != Integer.MAX_VALUE && !visited.get(i)) {
                    int newDist = dist.get(minIndex) + matrix[minIndex][i];
                    if (newDist < dist.get(i)) {
                        preVector.set(i, minIndex);
                        dist.set(i, newDist);
                    }
                }
            }

            // 封装返回结果，path记录从源点到当前节点的路径，由前驱节点逆序得到
            List<Integer> path = new ArrayList<>();
            Integer node = minIndex;
            path.add(node);
            while (node != start) {
                node = preVector.get(node);
                path.add(node);
            }
            Collections.reverse(path);
            resultMap.put(new Integer[]{minIndex, dist.get(minIndex)}, path);
        }

        // 返回结果
        return resultMap;
    }
}

public class Dijstra {

    public static void main(String[] args) {
        // 初始化邻接矩阵，设置为无穷大值
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        // 设置权重
        matrix[0][1] = 10;
        matrix[0][4] = 5;
        matrix[1][2] = 1;
        matrix[1][4] = 2;
        matrix[2][3] = 4;
        matrix[3][0] = 7;
        matrix[3][2] = 6;
        matrix[4][1] = 3;
        matrix[4][2] = 9;
        matrix[4][3] = 2;
        int V_count = 5;

        // 创建图
        Graph g = new Graph(V_count, matrix);

        // 计算所有非源点到其他节点的最短路径
        Map<Integer[], List<Integer>> shortestPath = g.getShortestPath(0);
        for (Map.Entry<Integer[], List<Integer>> entry : shortestPath.entrySet()) {
            System.out.println("源点到节点:" + entry.getKey()[0] + " 的最短距离为：" + entry.getKey()[1] + "，最短路径为：" + entry.getValue());
        }
    }
}
