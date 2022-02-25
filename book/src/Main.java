class Main {
    private static int recursiveSearch(int[] arrayToSearch, int lowIndex, int highIndex, int element) {
        if (highIndex >= lowIndex) {
            int mid = lowIndex + (highIndex - lowIndex) / 2;
            if ((mid != arrayToSearch.length - 1) && (arrayToSearch[mid + 1] == element)) {
                return recursiveSearch(arrayToSearch, mid + 1, highIndex, element);
            }
            if (arrayToSearch[mid] == element) {
                return arrayToSearch.length-1-mid;
            }
            if (arrayToSearch[mid] > element)
                return recursiveSearch(arrayToSearch, lowIndex, mid - 1, element);

            return recursiveSearch(arrayToSearch, mid + 1, highIndex, element);
        }
        return -1;
    }

    public static int recursiveSearch(int[] arrayToSearch, int element) {
        return recursiveSearch(arrayToSearch, 0, arrayToSearch.length - 1, element);
    }

    public static void main(String[] args) {
        int[] arr = {14, 14, 16, 19, 32, 32, 32, 32, 56, 69, 69, 69, 72};
        int findElement = 32;
        int pos = recursiveSearch(arr, findElement);
        if (pos == -1) {
            System.out.println("Item not found");
        } else {
            System.out.printf("After %d elements there are %d elements left", findElement, pos);
        }
    }
}