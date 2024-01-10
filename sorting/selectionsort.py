arr = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
count = 0
def selectionSort(n):
    global count
    for i in range(n):
        for j in range(n):
            count += 1
            if arr[i] < arr[j]:
                arr[i],arr[j] = arr[j],arr[i]

selectionSort(len(arr))

print(arr,count)