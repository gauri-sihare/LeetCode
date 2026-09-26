class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [0]*len(nums)
        res[0] = nums[0]
        for x in range(1,len(nums)):
            res[x] = res[x-1]+nums[x]

        return res