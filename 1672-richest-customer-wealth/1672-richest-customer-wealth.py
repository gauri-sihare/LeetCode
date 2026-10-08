class Solution(object):
    def maximumWealth(self, accounts):
        """
        :type accounts: List[List[int]]
        :rtype: int
        """
        maxi  =  float('-inf')
        for i in accounts:
            sum=0
            for j in i:
                sum += j
            maxi =  max(sum , maxi)
        return maxi


