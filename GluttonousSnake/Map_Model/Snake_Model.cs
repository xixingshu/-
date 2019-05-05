using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Map_Model
{
    /// <summary>
    /// 蛇身设计
    /// </summary>
    public class Snake_Model
    {
        /// <summary>
        /// 移动速度
        /// </summary>
        public int Speed { get; set; }
        /// <summary>
        /// 蛇身颜色
        /// </summary>
        public Color Color { get; set; }
        /// <summary>
        /// 运动方向
        /// </summary>
        public ModelEnum.Direction Direction { get; set; }
        /// <summary>
        /// 蛇身格子实体结合
        /// </summary>
        public List<Grid> Body { get; set; }
    }

    public class ModelEnum
    {
        public enum Direction
        {
            Up = 0,
            Left = 1,
            Down = 2,
            Right = 3
        }
    }
}
