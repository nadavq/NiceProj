# NiceProject
run - Main in the Interface module



The time complexity of the solution is O(n) while n is the number of entries that appear in the file.
That is obtained by the fact that for every id user we extract from each line, we check
if it already exists in the daily active user's entity set, which takes O(1).
For d - the number of individual dates that appear in the file and for k - the number of individual users that
entered for each date, the space complexity is - O(d+k), as every date has a different node in the linked list
and every user id entered at that date is contained in a set in that node.

The runtime complexity cannot be improved more than that because in each case we will have to go
through each line in the file in order to check if the current id has already entered on that date.

The solution assumes that the dates in the file are in ascending order by line.
If not, i would have implemented a map where the date is the key and the set is the value and
searched the map for the requested date.

