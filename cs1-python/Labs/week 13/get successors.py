get successors
#old
for r in range(len(config.board)):
    for c in range(len(config.board)):
        tempLst=[]
        grassboard = deepcopy(config)
        graddboard.board[r][c] = tentsConfig.GRASS
        grassboard.marker = (r,c)
        tempLst.append(grassboard)
        tentboard = deepcopy(config)
        tentboard.board[r][c] = tentsConfig.TENT
        tentboard.marker = (r,c)
        tempLst.append(tentboard)
        return tempLst
    return []
