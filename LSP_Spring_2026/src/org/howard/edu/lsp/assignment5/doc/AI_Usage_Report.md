# IntegerSet Implementation – Prompt & Notes

## Prompt

Implement a Java class `IntegerSet` with strict requirements around:

* Package structure
* Required methods (set operations, utilities, etc.)
* No duplicates
* Immutability for set operations
* Exact `toString()` formatting (`[1, 2, 3]`, sorted, no extra spaces)

---

## Notes / Approach

I implemented the full `IntegerSet` class independently using an `ArrayList<Integer>` as the underlying data structure. The overall design followed standard set behavior, with manual checks to prevent duplicates and ensure correctness across operations.

### What Worked Well

* Core methods like `add`, `remove`, `contains`, `length`, and `isEmpty` were straightforward since they map closely to `ArrayList` operations.
* Set operations (`union`, `intersect`, `diff`, `complement`) were implemented using loops and conditional checks based on standard set definitions.
* I made sure early on that all set operations return new `IntegerSet` instances instead of modifying the originals.

### Small Clarifications / Fixes

I only needed minor guidance on a few details:

* Making sure `equals()` compares sorted versions of both sets so order does not matter
* Double-checking that none of the set operations accidentally mutate the original sets
* Tightening the formatting in `toString()` to exactly match `[1, 2, 3]` (especially spacing and ordering)
* Handling edge cases like calling `largest()` or `smallest()` on an empty set

---

## Final Outcome

The final implementation meets all requirements:

* Correct package structure and method definitions
* No duplicate values
* Proper immutability for all set operations
* Accurate equality checks regardless of order
* Exact output formatting for `toString()`

Overall, the implementation was mostly straightforward, with only minor adjustments needed to fully align with the strict requirements.
