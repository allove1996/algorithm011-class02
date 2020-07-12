学习笔记
#### 递归模板
```
public void recur(int level, int param){
    // temination
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level+1, newParam);
    
    // restore current status
}
```

#### 分治模板
```
public void divide_conquer(problem, param1, param2 .....) {
    // recursion termination
    if (problem == null) {
        // process result
        return;
    }

    // process data
    data = prepare_data(problem);
    subproblems = split_problem(problem, data);
    
    // conquer subproblems
    subresult1 = divide_conquer(subproblems[0], p1, p2 ...);
    subresult2 = divide_conquer(subproblems[1], p1, p2....);
    subresult3 = divide_conquer(subproblema[3], p1, p2 ...);

    // process and gererate final result;
    result  = process_result(subresult1, subresult2, subresult3);

    // revert the current level status
}
```

