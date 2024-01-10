import timeit
# count = 0
arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

count = 0

def quickSort(left,right):
    global count
    if(left<right):
        pivot = left
        l = left
        r = right
        while(l<r):
            count += 1
            if(pivot == r):
                if(arr[pivot]<arr[l]):
                    arr[pivot],arr[l] = arr[l],arr[pivot]
                    pivot = l
                    r -= 1
                else:
                    l += 1
            else:
                if(arr[pivot]>arr[r]):
                    arr[pivot],arr[r] = arr[r],arr[pivot]
                    pivot = r
                    l += 1
                else:
                    r -= 1
        quickSort(left,pivot-1)
        quickSort(pivot+1,right)
quickSort(0,len(arr)-1)
print(count )

print(arr)


