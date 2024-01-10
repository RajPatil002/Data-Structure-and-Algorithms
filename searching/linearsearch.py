arr = [10,9,8,7,6,5,4,3,2,1]
# count = 0
def linearSearch(item):
    # global count
    for i in range(len(arr)):
        # count += 1
        if arr[i] == item:
            return i + 1
    return -1

index = linearSearch(1)

print(index,'count')