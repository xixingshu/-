using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Map_Model
{
    /// <summary>
    /// 格子的尺寸
    /// </summary>
    public class Grid_Model
    {
        /// <summary>
        /// 宽
        /// </summary>
        public int Width { get; set; }
        /// <summary>
        /// 长
        /// </summary>
        public int Height { get; set; }
    }


    /// <summary>
    /// 格子的坐标
    /// </summary>
    public class Grid
    {
        /// <summary>
        /// 横坐标
        /// </summary>
        public int X_Axis { get; set; }
        /// <summary>
        /// 纵坐标
        /// </summary>
        public int Y_Axis { get; set; }
        /// <summary>
        /// 当前格子是否存在食物
        /// </summary>
        public bool Food { get; set; }
        /// <summary>
        /// 格子初始化
        /// </summary>
        public Grid()
        {
            X_Axis = 0;
            Y_Axis = 0;
            Food = false;
        }

    }
}
