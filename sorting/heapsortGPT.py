

from timeit import timeit


def heapify(arr, n, i):
    largest = i    # Initialize the root as the largest
    left_child = 2 * i + 1
    right_child = 2 * i + 2

    # Check if left child exists and is greater than the root
    if left_child < n and arr[left_child] > arr[largest]:
        largest = left_child

    # Check if right child exists and is greater than the current largest
    if right_child < n and arr[right_child] > arr[largest]:
        largest = right_child

    # Swap the root (largest) with the largest child if needed
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        # Recursively heapify the affected sub-tree
        print(arr,largest)
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)

    # Build a max heap (rearrange elements)
    for i in range(n // 2 - 1, -1, -1):
        print("here",arr)
        heapify(arr, n, i)

    # Extract elements one by one from the heap
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # Swap the root (max) with the last element
        heapify(arr, i, 0)  # Heapify the reduced heap

# Example usage:
arr = [10,9,8,7,6,5,4,3,2,1]

print(timeit(lambda:heap_sort(arr)))

# count = 0
#     # global count
#     # count += 1
#     global count
#     count += 1