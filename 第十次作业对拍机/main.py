# 导入os和filecmp模块
import os
import re
import shutil

# 读入一个参数n，表示循环次数
mode = int(input("Please enter test mode:"))
while mode != 1 and mode != 0:
    print("Wrong mode!\nPlease enter 0 for self-test or 1 for auto-test")
    mode = int(input("Please enter test mode:"))

if mode == 0:
    n = 1
else:
    if mode == 1:
        n = int(input("Times of tests:"))

# 在程序开始运行时，清空log.txt和err.txt
with open("log.txt", "w") as log, open("err.txt", "w") as err:
    log.write("")
    err.write("")

# 获取当前目录下的所有文件名
files = os.listdir(".")

# 遍历文件名，找出.jar文件
for file in files:
    # 如果文件名以.jar结尾，且不是Generator.jar，说明是一个.jar文件
    if file.endswith(".jar") and file != "Generator.jar":
        # 为每个文件的输出单独建立一个目录，命名为file_output
        directory = file[:-4] + "_output"
        # 检查目录是否已经存在，如果不存在，就创建
        if not os.path.exists(directory):
            os.mkdir(directory)
        else:
            command = "rd /S /Q " + directory
            os.system(command)
            os.mkdir(directory)

# 循环执行n次
for i in range(1, n+1):
    # 创建一个空列表，用于存储输出结果
    results = []

    # 如果模式为1，在每次循环时首先执行Generator.jar，并将输出存放到stdin.txt中
    if mode == 1:
        command = "java -jar Generator.jar > stdin.txt"
        os.system(command)
        # 将Generator生成的stdin.txt同步保存到data目录下的stdini.txt中
        if not os.path.exists("data"):
            os.mkdir("data")
        shutil.copyfile("stdin.txt", "data/stdin" + str(i) + ".txt")

    # 遍历文件名，找出.jar文件
    for file in files:
        # 如果文件名以.jar结尾，且不是Generator.jar，说明是一个.jar文件
        if file.endswith(".jar") and file != "Generator.jar":
            # 获取之前创建的目录名
            directory = file[:-4] + "_output"
            # 构造命令行指令，使用java -jar命令运行.jar文件，将stdin.txt作为标准输入，将输出重定向到目录下的outputi.txt
            command = "java -jar " + file + " < stdin.txt > " + directory + "/output" + str(i) + ".txt"
            # 执行命令行指令
            os.system(command)
            # 判断输出文件是否存在，如果不存在，就创建一个空文件
            output_file = directory + "/output" + str(i) + ".txt"
            if not os.path.exists(output_file):
                open(output_file, "w").close()
            # 将输出结果添加到列表中
            results.append(output_file)

    # 创建一个变量，用于记录是否有不同的结果
    different = False

    # 在比较阶段，去除所有空白符和换行符
    for j in range(len(results)):
        for k in range(j + 1, len(results)):
            # 读取两个文件的内容
            with open(results[j], "r") as f1, open(results[k], "r") as f2:
                content1 = f1.read()
                content2 = f2.read()
            # 使用re.sub函数，将所有空白符和换行符替换为空字符串
            content1 = re.sub(r"\s+", "", content1)
            content2 = re.sub(r"\s+", "", content2)
            # 比较两个内容是否相同
            if content1 != content2:
                # 如果不相同，打印出文件名和提示信息
                if not different:
                    message = f"Test Point " + str(i) + ": \nOutput of " + results[j][:-4] + " and " + results[k][:-4] + " is different!"
                else:
                    message = f"Output of " + results[j][:-4] + " and " + results[k][:-4] + " is different!"
                print(message)
                # 将不相同的信息写入到log.txt和err.txt中
                with open("log.txt", "a") as log, open("err.txt", "a") as err:
                    log.write(message + "\n")
                    err.write(message + "\n")
                # 将变量设为True，表示有不同的结果
                different = True
                # 重新读取两个文件的内容，按行分割
                with open(results[j], "r") as f1, open(results[k], "r") as f2:
                    lines1 = f1.readlines()
                    lines2 = f2.readlines()
                # 遍历两个文件的每一行，找出第一个不同的行数
                for a in range(min(len(lines1), len(lines2))):
                    # 去除每一行的空白符和换行符
                    line1 = re.sub(r"\s+", "", lines1[a])
                    line2 = re.sub(r"\s+", "", lines2[a])
                    # 比较两个行是否相同
                    if line1 != line2:
                        # 如果不相同，打印出行数和提示信息
                        message = "First difference at line {}\n".format(a + 1)
                        print(message)
                        # 将不相同的信息写入到log.txt和err.txt中
                        with open("log.txt", "a") as log, open("err.txt", "a") as err:
                            log.write(message + "\n")
                            err.write(message + "\n")
                        # 跳出循环
                        break
    # 如果没有不同的结果，向log.txt中写入:Test Point i: All Accepted!,并换行
    if not different:
        print("Test Point {}: \nAll Accepted!\n".format(i))
        with open("log.txt", "a") as log:
            log.write("Test Point {}: \nAll Accepted!\n".format(i))