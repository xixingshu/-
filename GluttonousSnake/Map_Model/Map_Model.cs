using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Map_Model
{
    /// <summary>
    /// 地图设计
    /// </summary>
    public class Model_Map
    {
        /// <summary>
        /// 行定义
        /// </summary>
        public int Row { get; set; }
        /// <summary>
        /// 列定义
        /// </summary>
        public int Column { get; set; }
        /// <summary>
        /// 纹路颜色
        /// </summary>
        public Color Line { get; set; }
        /// <summary>
        /// 格子颜色
        /// </summary>
        public Color Color { get; set; }
        /// <summary>
        /// 格子大小
        /// </summary>
        public Grid_Model Box { get; set; }
        /// <summary>
        /// 格子集合
        /// </summary>
        public List<Grid> Body { get; set; }
    }

}
