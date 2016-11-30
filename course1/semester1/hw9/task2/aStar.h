#pragma once

struct Map;

Map *loadMap(char *path);

char *output(Map *map);

void deleteMap(Map *&map);