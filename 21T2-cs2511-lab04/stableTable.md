+-------------------------------+----------------+---------------------+---------------------+---------------------+--------+-------------+
|            Action             |   Condition    | AspectRatioDragging |      Dragging       |        Shape        | Simple |  Selected   |
+-------------------------------+----------------+---------------------+---------------------+---------------------+--------+-------------+
| Shift Released                |                | DraggingState       |                     |                     |        |             |
| Shift Pressed                 |                |                     | AspectRatioDragging |                     |        |             |
| Primary Mouse Button Pressed  | Shift Key Held |                     |                     | AspectRatioDragging |        |             |
| Primary Mouse Button Pressed  |                |                     |                     | DraggingState       |        |             |
| Primary Mouse Button Released | tool=box-select| SelectedState       | SelectedState       |                     |        |             |
| Primary Mouse Button Released |                | ShapeState          | ShapeState          |                     |        |             |
| Escape Key                    |                | SimpleState         | SimpleState         | SimpleState         |        | SimpleState |
| Ctrl + D & Clicking Outside   |                |                     |                     |                     |        | ShapeState  |
+-------------------------------+----------------+---------------------+---------------------+---------------------+--------+-------------+
