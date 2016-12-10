#pragma once

struct Map;

Map *loadMap(char *path);

char *output(Map *map);
bool performAStar(Map *map, int startX, int startY, int finishX, int finishY);

void deleteMap(Map *&map);