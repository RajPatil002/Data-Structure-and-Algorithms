from timeit import timeit


def merge_sort(arr):
    if len(arr) > 1:
        # Step 1: Divide
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively apply Merge Sort to each half
        merge_sort(left_half)
        merge_sort(right_half)

        # Step 2: Combine
        i = j = k = 0

        # Compare elements from both halves and merge
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Check if there are any remaining elements in the left or right halves
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

# Example usage:
my_array = [38, 27, 43, 3, 9, 82, 10]

print("Done :", timeit(lambda:merge_sort(my_array)))
