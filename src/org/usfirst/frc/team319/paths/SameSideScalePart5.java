package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class SameSideScalePart5 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (19.42,20.08,0.00)
	// (22.92,20.75,0.00)
	
	public SameSideScalePart5() {
		this(false);
	}
			
    public SameSideScalePart5(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.015,0.291,10.000},
				{0.073,0.582,10.000},
				{0.204,1.310,10.000},
				{0.437,2.328,10.000},
				{0.800,3.636,10.000},
				{1.323,5.231,10.000},
				{2.034,7.110,10.000},
				{2.947,9.125,10.000},
				{4.060,11.129,10.000},
				{5.372,13.118,10.000},
				{6.880,15.090,10.000},
				{8.585,17.042,10.000},
				{10.482,18.972,10.000},
				{12.570,20.878,10.000},
				{14.845,22.758,10.000},
				{17.306,24.609,10.000},
				{19.949,26.429,10.000},
				{22.771,28.216,10.000},
				{25.768,29.968,10.000},
				{28.936,31.685,10.000},
				{32.272,33.363,10.000},
				{35.773,35.002,10.000},
				{39.432,36.599,10.000},
				{43.248,38.155,10.000},
				{47.215,39.667,10.000},
				{51.328,41.135,10.000},
				{55.584,42.558,10.000},
				{59.977,43.935,10.000},
				{64.504,45.265,10.000},
				{69.159,46.549,10.000},
				{73.938,47.787,10.000},
				{78.835,48.977,10.000},
				{83.847,50.121,10.000},
				{88.969,51.218,10.000},
				{94.196,52.269,10.000},
				{99.524,53.276,10.000},
				{104.947,54.238,10.000},
				{110.463,55.157,10.000},
				{116.066,56.034,10.000},
				{121.753,56.871,10.000},
				{127.520,57.669,10.000},
				{133.364,58.431,10.000},
				{139.279,59.159,10.000},
				{145.265,59.855,10.000},
				{151.317,60.523,10.000},
				{157.434,61.164,10.000},
				{163.612,61.783,10.000},
				{169.850,62.384,10.000},
				{176.147,62.969,10.000},
				{182.502,63.544,10.000},
				{188.913,64.112,10.000},
				{195.381,64.679,10.000},
				{201.906,65.250,10.000},
				{208.489,65.831,10.000},
				{215.132,66.426,10.000},
				{221.836,67.043,10.000},
				{228.605,67.688,10.000},
				{235.441,68.366,10.000},
				{242.350,69.086,10.000},
				{249.335,69.854,10.000},
				{256.403,70.677,10.000},
				{263.559,71.564,10.000},
				{270.812,72.521,10.000},
				{278.167,73.556,10.000},
				{285.635,74.677,10.000},
				{293.224,75.892,10.000},
				{300.945,77.207,10.000},
				{308.808,78.631,10.000},
				{316.825,80.171,10.000},
				{325.008,81.833,10.000},
				{333.371,83.625,10.000},
				{341.926,85.552,10.000},
				{350.688,87.621,10.000},
				{359.672,89.836,10.000},
				{368.892,92.202,10.000},
				{378.355,94.631,10.000},
				{388.057,97.024,10.000},
				{397.995,99.372,10.000},
				{408.161,101.663,10.000},
				{418.549,103.882,10.000},
				{429.150,106.012,10.000},
				{439.954,108.034,10.000},
				{450.957,110.032,10.000},
				{462.167,112.102,10.000},
				{473.591,114.236,10.000},
				{485.234,116.429,10.000},
				{497.101,118.676,10.000},
				{509.198,120.972,10.000},
				{521.530,123.310,10.000},
				{534.098,125.688,10.000},
				{546.908,128.100,10.000},
				{559.963,130.542,10.000},
				{573.264,133.011,10.000},
				{586.814,135.502,10.000},
				{600.615,138.013,10.000},
				{614.669,140.541,10.000},
				{628.977,143.081,10.000},
				{643.541,145.632,10.000},
				{658.360,148.190,10.000},
				{673.435,150.753,10.000},
				{688.767,153.319,10.000},
				{704.355,155.884,10.000},
				{720.200,158.446,10.000},
				{736.300,161.002,10.000},
				{752.655,163.550,10.000},
				{769.264,166.086,10.000},
				{786.124,168.609,10.000},
				{803.236,171.114,10.000},
				{820.596,173.598,10.000},
				{838.202,176.059,10.000},
				{856.051,178.492,10.000},
				{874.140,180.894,10.000},
				{892.466,183.259,10.000},
				{911.024,185.585,10.000},
				{929.811,187.865,10.000},
				{948.820,190.095,10.000},
				{968.048,192.271,10.000},
				{987.486,194.385,10.000},
				{1007.129,196.432,10.000},
				{1026.964,198.347,10.000},
				{1046.957,199.928,10.000},
				{1067.060,201.028,10.000},
				{1087.222,201.630,10.000},
				{1107.394,201.716,10.000},
				{1127.521,201.272,10.000},
				{1147.550,200.288,10.000},
				{1167.432,198.818,10.000},
				{1187.138,197.059,10.000},
				{1206.653,195.149,10.000},
				{1225.962,193.095,10.000},
				{1245.052,190.901,10.000},
				{1263.910,188.573,10.000},
				{1282.521,186.118,10.000},
				{1300.876,183.543,10.000},
				{1318.961,180.855,10.000},
				{1336.767,178.060,10.000},
				{1354.284,175.166,10.000},
				{1371.502,172.182,10.000},
				{1388.413,169.114,10.000},
				{1405.011,165.970,10.000},
				{1421.286,162.758,10.000},
				{1437.235,159.486,10.000},
				{1452.851,156.160,10.000},
				{1468.130,152.789,10.000},
				{1483.068,149.378,10.000},
				{1497.661,145.936,10.000},
				{1511.908,142.468,10.000},
				{1525.806,138.980,10.000},
				{1539.354,135.479,10.000},
				{1552.551,131.971,10.000},
				{1565.397,128.461,10.000},
				{1577.893,124.953,10.000},
				{1590.038,121.453,10.000},
				{1601.834,117.965,10.000},
				{1613.284,114.493,10.000},
				{1624.388,111.042,10.000},
				{1635.149,107.614,10.000},
				{1645.570,104.212,10.000},
				{1655.655,100.841,10.000},
				{1665.405,97.502,10.000},
				{1674.824,94.197,10.000},
				{1683.917,90.930,10.000},
				{1692.688,87.702,10.000},
				{1701.139,84.515,10.000},
				{1709.276,81.370,10.000},
				{1717.103,78.268,10.000},
				{1724.624,75.211,10.000},
				{1731.844,72.199,10.000},
				{1738.767,69.234,10.000},
				{1745.399,66.314,10.000},
				{1751.743,63.442,10.000},
				{1757.805,60.617,10.000},
				{1763.588,57.838,10.000},
				{1769.099,55.106,10.000},
				{1774.341,52.420,10.000},
				{1779.319,49.779,10.000},
				{1784.037,47.183,10.000},
				{1788.500,44.632,10.000},
				{1792.713,42.123,10.000},
				{1796.678,39.656,10.000},
				{1800.401,37.230,10.000},
				{1803.886,34.843,10.000},
				{1807.135,32.493,10.000},
				{1810.153,30.179,10.000},
				{1812.943,27.899,10.000},
				{1815.508,25.652,10.000},
				{1817.851,23.434,10.000},
				{1819.976,21.245,10.000},
				{1821.884,19.081,10.000},
				{1823.578,16.941,10.000},
				{1825.060,14.822,10.000},
				{1826.332,12.722,10.000},
				{1827.396,10.638,10.000},
				{1828.253,8.568,10.000},
				{1828.908,6.555,10.000},
				{1829.383,4.743,10.000},
				{1829.705,3.228,10.000},
				{1829.906,2.007,10.000},
				{1830.014,1.079,10.000},
				{1830.058,0.444,10.000},
				{1830.068,0.099,10.000},
				{1830.068,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.015,0.291,10.000},
				{0.073,0.583,10.000},
				{0.204,1.311,10.000},
				{0.437,2.332,10.000},
				{0.802,3.646,10.000},
				{1.327,5.255,10.000},
				{2.043,7.162,10.000},
				{2.966,9.224,10.000},
				{4.095,11.298,10.000},
				{5.434,13.387,10.000},
				{6.983,15.493,10.000},
				{8.745,17.618,10.000},
				{10.722,19.765,10.000},
				{12.915,21.937,10.000},
				{15.329,24.135,10.000},
				{17.965,26.362,10.000},
				{20.827,28.619,10.000},
				{23.918,30.910,10.000},
				{27.241,33.235,10.000},
				{30.801,35.596,10.000},
				{34.601,37.996,10.000},
				{38.644,40.435,10.000},
				{42.936,42.914,10.000},
				{47.479,45.437,10.000},
				{52.279,48.002,10.000},
				{57.341,50.612,10.000},
				{62.667,53.267,10.000},
				{68.264,55.967,10.000},
				{74.135,58.714,10.000},
				{80.286,61.508,10.000},
				{86.721,64.348,10.000},
				{93.444,67.235,10.000},
				{100.461,70.169,10.000},
				{107.776,73.150,10.000},
				{115.394,76.176,10.000},
				{123.319,79.247,10.000},
				{131.555,82.363,10.000},
				{140.107,85.521,10.000},
				{148.979,88.722,10.000},
				{158.176,91.963,10.000},
				{167.700,95.242,10.000},
				{177.555,98.557,10.000},
				{187.746,101.907,10.000},
				{198.275,105.288,10.000},
				{209.145,108.699,10.000},
				{220.358,112.135,10.000},
				{231.918,115.593,10.000},
				{243.825,119.070,10.000},
				{256.081,122.563,10.000},
				{268.687,126.066,10.000},
				{281.645,129.575,10.000},
				{294.953,133.085,10.000},
				{308.613,136.592,10.000},
				{322.622,140.089,10.000},
				{336.979,143.571,10.000},
				{351.682,147.032,10.000},
				{366.728,150.465,10.000},
				{382.115,153.864,10.000},
				{397.837,157.222,10.000},
				{413.890,160.532,10.000},
				{430.269,163.786,10.000},
				{446.966,166.977,10.000},
				{463.976,170.098,10.000},
				{481.290,173.140,10.000},
				{498.900,176.096,10.000},
				{516.796,178.959,10.000},
				{534.968,181.721,10.000},
				{553.405,184.375,10.000},
				{572.097,186.913,10.000},
				{591.029,189.328,10.000},
				{610.191,191.614,10.000},
				{629.567,193.764,10.000},
				{649.145,195.774,10.000},
				{668.908,197.636,10.000},
				{688.843,199.347,10.000},
				{708.913,200.705,10.000},
				{729.065,201.516,10.000},
				{749.244,201.789,10.000},
				{769.398,201.536,10.000},
				{789.475,200.774,10.000},
				{809.427,199.518,10.000},
				{829.205,197.788,10.000},
				{848.784,195.789,10.000},
				{868.156,193.720,10.000},
				{887.315,191.585,10.000},
				{906.254,189.392,10.000},
				{924.969,187.145,10.000},
				{943.454,184.850,10.000},
				{961.705,182.511,10.000},
				{979.718,180.134,10.000},
				{997.490,177.722,10.000},
				{1015.018,175.280,10.000},
				{1032.299,172.811,10.000},
				{1049.331,170.319,10.000},
				{1066.112,167.808,10.000},
				{1082.640,165.281,10.000},
				{1098.914,162.741,10.000},
				{1114.933,160.190,10.000},
				{1130.697,157.632,10.000},
				{1146.203,155.069,10.000},
				{1161.454,152.503,10.000},
				{1176.448,149.938,10.000},
				{1191.185,147.376,10.000},
				{1205.667,144.820,10.000},
				{1219.894,142.272,10.000},
				{1233.868,139.736,10.000},
				{1247.589,137.213,10.000},
				{1261.060,134.708,10.000},
				{1274.282,132.223,10.000},
				{1287.259,129.763,10.000},
				{1299.992,127.330,10.000},
				{1312.485,124.928,10.000},
				{1324.741,122.563,10.000},
				{1336.764,120.237,10.000},
				{1348.560,117.957,10.000},
				{1360.133,115.726,10.000},
				{1371.488,113.551,10.000},
				{1382.632,111.437,10.000},
				{1393.570,109.389,10.000},
				{1404.309,107.382,10.000},
				{1414.841,105.325,10.000},
				{1425.158,103.165,10.000},
				{1435.250,100.922,10.000},
				{1445.111,98.612,10.000},
				{1454.736,96.249,10.000},
				{1464.120,93.844,10.000},
				{1473.264,91.435,10.000},
				{1482.175,89.117,10.000},
				{1490.870,86.949,10.000},
				{1499.363,84.926,10.000},
				{1507.667,83.042,10.000},
				{1515.796,81.292,10.000},
				{1523.763,79.669,10.000},
				{1531.580,78.167,10.000},
				{1539.258,76.778,10.000},
				{1546.807,75.495,10.000},
				{1554.238,74.311,10.000},
				{1561.560,73.218,10.000},
				{1568.781,72.208,10.000},
				{1575.908,71.274,10.000},
				{1582.949,70.408,10.000},
				{1589.909,69.603,10.000},
				{1596.794,68.851,10.000},
				{1603.609,68.145,10.000},
				{1610.357,67.478,10.000},
				{1617.041,66.843,10.000},
				{1623.664,66.234,10.000},
				{1630.229,65.643,10.000},
				{1636.735,65.067,10.000},
				{1643.185,64.497,10.000},
				{1649.578,63.930,10.000},
				{1655.914,63.360,10.000},
				{1662.192,62.782,10.000},
				{1668.412,62.193,10.000},
				{1674.570,61.587,10.000},
				{1680.666,60.961,10.000},
				{1686.698,60.312,10.000},
				{1692.661,59.635,10.000},
				{1698.554,58.929,10.000},
				{1704.373,58.191,10.000},
				{1710.115,57.417,10.000},
				{1715.776,56.607,10.000},
				{1721.351,55.757,10.000},
				{1726.838,54.867,10.000},
				{1732.231,53.934,10.000},
				{1737.527,52.958,10.000},
				{1742.721,51.938,10.000},
				{1747.808,50.872,10.000},
				{1752.784,49.760,10.000},
				{1757.644,48.602,10.000},
				{1762.384,47.396,10.000},
				{1766.998,46.144,10.000},
				{1771.483,44.845,10.000},
				{1775.833,43.500,10.000},
				{1780.044,42.108,10.000},
				{1784.111,40.671,10.000},
				{1788.030,39.189,10.000},
				{1791.796,37.663,10.000},
				{1795.406,36.094,10.000},
				{1798.854,34.483,10.000},
				{1802.137,32.832,10.000},
				{1805.251,31.142,10.000},
				{1808.193,29.414,10.000},
				{1810.958,27.650,10.000},
				{1813.543,25.852,10.000},
				{1815.945,24.022,10.000},
				{1818.161,22.162,10.000},
				{1820.189,20.274,10.000},
				{1822.025,18.360,10.000},
				{1823.667,16.423,10.000},
				{1825.113,14.464,10.000},
				{1826.362,12.487,10.000},
				{1827.411,10.493,10.000},
				{1828.260,8.485,10.000},
				{1828.911,6.513,10.000},
				{1829.384,4.724,10.000},
				{1829.706,3.220,10.000},
				{1829.906,2.005,10.000},
				{1830.014,1.079,10.000},
				{1830.058,0.444,10.000},
				{1830.068,0.099,10.000},
				{1830.068,0.000,10.000}
		};
		
		if (flipped) {
			rightProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			leftProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		} else {
			leftProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			rightProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		}
	}

}