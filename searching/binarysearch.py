arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# count = 0

def binarySearch(item):
    # global count
    i = 0
    j = len(arr)
    while(i<j):
        # count += 1
        mid = i+(j-i) // 2
        if  arr[mid] == item:
            return mid + 1
        elif arr[mid] > item:
            j = mid - 1
        else:
            i = mid + 1
    return -1


index = binarySearch(10)

print(index,'count')