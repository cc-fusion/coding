#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>

using Bool2D = std::vector<std::vector<bool>>;

struct Point {
    int x;
    int y;
    bool operator==(const Point& otherPt) const {
        return otherPt.x == this->x && otherPt.y == this->y;
    }
};

auto getPointHash(int gridHeight) {
    return [gridHeight](const Point& pt) {
        return static_cast<size_t>(pt.y + pt.x * gridHeight);
    };
}

template <typename H>
void countIslandsHelper(const Bool2D& islandGrid, std::unordered_set<Point, H>& visitedPoints, const Point currPt) {
    int gridHeight {static_cast<int>(islandGrid.size())};
    int gridWidth {static_cast<int>(islandGrid[currPt.x].size())};
    
    visitedPoints.emplace(currPt);
    
    bool isTopLand    {currPt.y >= 1             && islandGrid[currPt.y-1][currPt.x  ]};
    bool isBottomLand {currPt.y < gridHeight - 1 && islandGrid[currPt.y+1][currPt.x  ]};
    bool isLeftLand   {currPt.x >= 1             && islandGrid[currPt.y  ][currPt.x-1]};
    bool isRightLand  {currPt.x < gridWidth - 1  && islandGrid[currPt.y  ][currPt.x+1]};
    
    if (isTopLand) {
        Point updatedPt {currPt.x, currPt.y - 1};
        if (!visitedPoints.contains(updatedPt)) countIslandsHelper(islandGrid, visitedPoints, updatedPt);
    }
    if (isBottomLand) {
        Point updatedPt {currPt.x, currPt.y + 1};
        if (!visitedPoints.contains(updatedPt)) countIslandsHelper(islandGrid, visitedPoints, updatedPt);
    }
    if (isLeftLand) {
        Point updatedPt {currPt.x - 1, currPt.y};
        if (!visitedPoints.contains(updatedPt)) countIslandsHelper(islandGrid, visitedPoints, updatedPt);
    }
    if (isRightLand) {
        Point updatedPt {currPt.x + 1, currPt.y};
        if (!visitedPoints.contains(updatedPt)) countIslandsHelper(islandGrid, visitedPoints, updatedPt);
    }
}

int countIslands(const Bool2D& islandGrid) {
    int gridHeight {static_cast<int>(islandGrid.size())};
    auto pointHash {getPointHash(gridHeight)};
    std::unordered_set<Point, decltype(pointHash)> visitedPoints (0, pointHash);
    int islandCount {0};
    
    for (int y = 0; y < gridHeight; y++) {
        int gridWidth {static_cast<int>(islandGrid[y].size())};
        for (int x = 0; x < gridWidth; x++) {
            Point currPt {x, y};
            if (visitedPoints.contains(currPt)) continue;
            if (islandGrid[y][x]) {
                countIslandsHelper(islandGrid, visitedPoints, currPt);
                islandCount++;
            }
        }
    }
    return islandCount;
}

int main() {
    std::vector<std::vector<bool>> islandGrid {
        {0,0,1,0,0},
        {0,1,1,1,0},
        {0,0,0,0,0},
        {0,0,1,0,0},
        {0,1,0,0,1}
    };
    std::cout << countIslands(islandGrid) << "\n";
}
