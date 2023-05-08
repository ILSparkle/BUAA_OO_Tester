# 读取stdin.txt的内容
import re
import shutil

with open("stdin.txt", "r") as f:
    lines = f.readlines()

with open("res.txt", "w") as f:
    f.write("")

cnt = int(input("请输入错误所在行数"))

with open("temp.txt", "w") as f:
    for i in range(cnt):
        f.write(lines[i])

shutil.copyfile("temp.txt", "stdin.txt")

with open("stdin.txt", "r") as f:
    lines = f.readlines()
# 定义一个函数，用于执行jar文件并返回输出
import subprocess
def run_jar(jar_file, input_file):
    # 使用java命令执行jar文件，并将input_file作为标准输入
    cmd = "java -jar " + jar_file
    with open(input_file, "r") as f:
        output = subprocess.check_output(cmd, stdin=f)
    # 返回输出的字符串形式
    return output.decode()

# 获取两个jar文件的初始输出
output1 = run_jar("code1.jar", "stdin.txt")
output1 = re.sub(r"\s+", "", output1)
output2 = run_jar("code2.jar", "stdin.txt")
output2 = re.sub(r"\s+", "", output2)

# 定义一个列表，用于存储不影响两程序输出不同的行的索引
res_lines = []
i = 0
# 遍历每一行
while i < len(lines):
    with open("stdin.txt", "r") as f:
        lines = f.readlines()
    cnt -= 1
    print("Left lines: " + str(len(lines)))
    # 创建一个临时文件，用于存储删除当前行后的输入
    with open("temp.txt", "w") as f:
        for j in range(len(lines)):
            # 如果不是当前行，就写入临时文件
            if j != i:
                f.write(lines[j])
    # 获取删除当前行后的两个jar文件的输出
    temp_output1 = run_jar("code1.jar", "temp.txt")
    temp_output1 = re.sub(r"\s+", "", temp_output1)
    temp_output2 = run_jar("code2.jar", "temp.txt")
    temp_output2 = re.sub(r"\s+", "", temp_output2)
    # 如果输出仍然不同，就将当前行的索引加入列表
    if temp_output1 == temp_output2:
        with open("res.txt", "a") as r:
            r.write((lines[i].strip()) + "\n")
        i += 1
    else:
        shutil.copyfile("temp.txt", "stdin.txt")
