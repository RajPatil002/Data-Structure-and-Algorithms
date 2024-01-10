import timeit

arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]


def quickSortGPT(left, right):
    if left < right:
        pivot = partition(left, right)
        quickSortGPT(left, pivot - 1)
        quickSortGPT(pivot + 1, right)

# pivot positioning and partitioning
def partition(left, right):
    pivot = arr[right]
    i = left - 1

    for j in range(left, right):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[right] = arr[right], arr[i + 1]
    return i + 1


print(timeit.timeit(lambda:quickSortGPT(0,len(arr)-1)))

print(arr)