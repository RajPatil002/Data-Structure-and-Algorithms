from timeit import timeit


arr = [10,9,8,7,6,5,4,3,2,1]

# switch with child if its bigger
# (max heap)
def heapify(i,n):
    l = i * 2 + 1
    r = l + 1
    if r < n and arr[l] < arr[r]:
        if arr[i] < arr[r]:
            arr[r],arr[i] = arr[i],arr[r]
            heapify(r,n)
    elif l < n :
        if arr[i] < arr[l]:
            arr[l],arr[i] = arr[i],arr[l]
            heapify(l,n)


def heapSort(n):
    # build heap
    for i in range(n//2-1,-1,-1):
        heapify(i,n)
    
    # extract from heap and rebuild
    for i in range(n-1,-1,-1):
        arr[0],arr[i] = arr[i],arr[0]
        heapify(0,i)




print(timeit(lambda:heapSort(len(arr))))

# count = 0
#     global count
#     count += 1
# def heapify(n):
#     for i in range(n,0,-1):
#         if arr[i] > arr[(i-1)//2]:
#             arr[i], arr[(i-1)//2] = arr[(i-1)//2],arr[i]

#     arr[0],arr[n] =arr[n],arr[0]

# def heapSort():
#     for i in range(len(arr)-1,-1,-1):
#         heapify(i)