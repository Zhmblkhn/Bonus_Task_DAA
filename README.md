# Bonus Task — Edge Removal and Reconnection in a Minimum Spanning Tree

This Java project demonstrates how to:
- Build a **Minimum Spanning Tree (MST)** using Kruskal’s algorithm,
- Remove an edge from the MST,
- Detect the resulting disconnected components,
- Efficiently find a **replacement edge** that reconnects the graph and maintains the MST property.

---

## Project Structure
```
Bonus_Task_DAA/
│ 
├── pom.xml
├── README.md 
└── src/ 
└── main/ 
└── java/ 
└── mst/ 
├── Edge.java # Class for representing graph edges 
├── DisjointSet.java # Union-Find structure for Kruskal’s algorithm 
├── Graph.java # Graph representation and edge storage 
├── KruskalMST.java # Implementation of MST builder 
└── Main.java # Main program logic 
```


---

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Zhmblkhn/Bonus_Task_DAA.git
   cd Bonus_Task_DAA
   
   mvn compile exec:java -Dexec.mainClass="mst.Main"

    ```


## Example Output
```
Initial MST edges:
(1 - 2, 1)
(1 - 3, 2)
(3 - 4, 2)
(0 - 2, 3)
(4 - 5, 6)
Total weight = 14

Removed edge: (1 - 3, 2)

Components after removal:
[0, 1, 2]
[3, 4, 5]

Replacement edge found: (2 - 3, 4)

New MST edges:
(1 - 2, 1)
(3 - 4, 2)
(0 - 2, 3)
(4 - 5, 6)
(2 - 3, 4)
New total weight = 16
```

## Implementation Details

- Algorithm used: Kruskal’s algorithm

- Data structure: Union-Find (Disjoint Set Union)

- Edge replacement logic:

  - After removing an MST edge, the tree splits into two components.

  - Among all non-MST edges, we select the lightest one that reconnects the two components.

  - This ensures the resulting graph remains an MST.
