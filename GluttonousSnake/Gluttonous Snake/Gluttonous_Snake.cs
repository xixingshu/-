/*************************************************
Copyright (C), 1988-1999, Huawei Tech. Co., Ltd.
File name:         贪吃蛇// 文件名
Author:    赵志鹏       Version:    0.1       Date:    2019-5-5 // 作者、版本及完成日期
Description:    // 用于详细说明此程序文件完成的主要功能，与其他模块
						 // 或函数的接口，输出值、取值范围、含义及参数间的控
						 // 制、顺序、独立或依赖等关系   Others:
						 // 其它内容的说明   Function List:  // 主要函数列表，每条记录应包括函数名及功能简要说明     1. ....
History:			2019-5-5   定义了一些常量与类
                                        // 修改历史记录列表，每条修改记录应包括修改日期、修改者及修改内容简述
*************************************************/
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace myGluttonous_nake
{
    public partial class Gluttonous_Snake : Form
    {
        public Gluttonous_Snake()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            MessageBox.Show("欢迎进入游戏");
        }

    }
}
