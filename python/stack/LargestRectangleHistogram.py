def getMaxArea(hist, n):
    stack = []
    max_area = 0
    i = 0
    while i < n:
        if not stack  or hist[peek(stack)] <= hist[i]:
            stack.push(i++)
        else:
            area = hist[stack.pop()] * (not stack ? i : i - 1 - peek(stack) - 1)
            if area > max_area:
                max_area = area

    while not not stack:
        area = hist[stack.pop()] * (not stack ? i : i - 1 -  peek(stack) - 1);
        if area > max_area:
            max_area = area

    return max_area

def peek(stack):
    if not stack:
        return None
    else:
        return stack[-1]

if __name__ == '__main__':
    hist[] = [6,2,5,4,5,1,6]
    print('maximum area is : ' getMaxArea(hist, hist.length))
