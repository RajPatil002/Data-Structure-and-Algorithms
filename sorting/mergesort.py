from timeit import timeit

arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
count = 0
def mergeSort(left,right):
    global count
    
    if(right-left>1):
        mid = left + (right - left)//2
        leftarr = mergeSort(left,mid)
        rightarr = mergeSort(mid,right)

        r = l = 0
        temp = []

        # add min elements first
        while(l<len(leftarr) and r<len(rightarr)):
            count += 1
            if(leftarr[l] < rightarr[r]):
                temp.append(leftarr[l])
                l += 1
            else:
                temp.append(rightarr[r])
                r += 1
        
        # add remaining elements use loops
        temp += leftarr[l:] + rightarr[r:]
        return temp
    return arr[left:right]

mergeSort(0,len(arr))
print("Done : ","timeit(lambda:)",count)