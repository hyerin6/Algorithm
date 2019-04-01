# 점화식과 점근적 복잡도 분석  
1. 재귀 알고리즘 분석  

(1) 이진 탐색  
**알고리즘**   
입력 배열의 중간 값과 찾을 값을 비교 (이미 정렬되어 있는 배열)  
비교 결과 찾을 값이 크면 중간 값의 뒤에서 찾고 작으면 앞에서 찾는다.   

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

(2) 정렬 #1  
**알고리즘**   
배열 A를 중간에서 반으로 쪼갠다. 쪼개진 배열의 앞부분을 A1, 뒷부분을 A2하고 하자. A1, A2의 크기는 n/2이다.   
A1 정렬 (재귀 호출), A2 정렬 (재귀 호출)   
정렬된 A1과 A2를 병합한다.   

**분석**  
배열을 반으로 쪼개는 것(그냥 위치를 기준으로 나눈 것) : o(1)   
배열의 크기가 1이 될 때까지 쪼개려면 logn회    
두 배열을 하나로 병합하는 것(값들을 하나씩 비교해가며 병합해야 한다.) : o(n)    

**점근적 분석**   
o(n logn)  

----------------  
**연습코드**    
1) algorithm1/src/net/skhu/array/Example4.java       
2) algorithm1/src/binaryTree/Example1.java           

