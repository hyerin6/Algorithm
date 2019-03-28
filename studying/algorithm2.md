# 점화식과 점근적 복잡도 분석  
1. 재귀 알고리즘 분석  
(1)이진 탐색  
```
static int search2(int[] a, int value) {
    int start = 0;
    int end = a.length - 1;
    while (start <= end) {
        int middle = (start + end) / 2;
        if (a[middle] < value) start = middle + 1;
        else if (a[middle] > value) end = middle - 1;
        else return middle;
    }
    return -1;
}
```  
Q. start와 end가 서로 같아도 반으로 나눠 비교해야 하는 이유는?
A. 같은 경우를 빼면 배열에 속성이 하나이면 찾지 못하는 문제가 발생하기 때문에 start와 end가 같아도 중간 값을 기준으로 비교해야 한다.  

while문을 한 번 반복할 때 마다 찾을 배열의 크기가 반으로 줄어들기 때문에 
점근적 분석 : o(log n)  

(2)정렬 #1  


