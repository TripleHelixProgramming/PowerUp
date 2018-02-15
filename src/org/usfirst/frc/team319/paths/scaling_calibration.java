package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class scaling_calibration extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (5.00,0.00,0.00)
	
	public scaling_calibration() {
		this(false);
	}
			
    public scaling_calibration(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.015,0.298,10.000},
				{0.075,0.597,10.000},
				{0.209,1.342,10.000},
				{0.447,2.386,10.000},
				{0.820,3.729,10.000},
				{1.357,5.369,10.000},
				{2.088,7.308,10.000},
				{3.043,9.545,10.000},
				{4.251,12.081,10.000},
				{5.742,14.914,10.000},
				{7.547,18.047,10.000},
				{9.694,21.477,10.000},
				{12.215,25.205,10.000},
				{15.138,29.232,10.000},
				{18.479,33.408,10.000},
				{22.237,37.584,10.000},
				{26.414,41.761,10.000},
				{31.007,45.937,10.000},
				{36.018,50.113,10.000},
				{41.447,54.289,10.000},
				{47.294,58.465,10.000},
				{53.558,62.641,10.000},
				{60.240,66.817,10.000},
				{67.339,70.993,10.000},
				{74.856,75.169,10.000},
				{82.790,79.345,10.000},
				{91.142,83.521,10.000},
				{99.912,87.697,10.000},
				{109.099,91.873,10.000},
				{118.704,96.049,10.000},
				{128.727,100.225,10.000},
				{139.167,104.401,10.000},
				{150.025,108.577,10.000},
				{161.300,112.753,10.000},
				{172.993,116.930,10.000},
				{185.104,121.106,10.000},
				{197.632,125.282,10.000},
				{210.578,129.458,10.000},
				{223.941,133.634,10.000},
				{237.722,137.810,10.000},
				{251.920,141.986,10.000},
				{266.537,146.162,10.000},
				{281.570,150.338,10.000},
				{297.022,154.514,10.000},
				{312.891,158.690,10.000},
				{329.177,162.866,10.000},
				{345.882,167.042,10.000},
				{363.004,171.218,10.000},
				{380.543,175.394,10.000},
				{398.500,179.570,10.000},
				{416.875,183.746,10.000},
				{435.667,187.922,10.000},
				{454.877,192.098,10.000},
				{474.504,196.275,10.000},
				{494.549,200.451,10.000},
				{515.012,204.627,10.000},
				{535.892,208.803,10.000},
				{557.190,212.979,10.000},
				{578.906,217.155,10.000},
				{601.039,221.331,10.000},
				{623.589,225.507,10.000},
				{646.558,229.683,10.000},
				{669.943,233.859,10.000},
				{693.747,238.035,10.000},
				{717.968,242.211,10.000},
				{742.607,246.387,10.000},
				{767.663,250.563,10.000},
				{793.137,254.739,10.000},
				{819.029,258.915,10.000},
				{845.338,263.091,10.000},
				{872.065,267.267,10.000},
				{899.209,271.444,10.000},
				{926.771,275.620,10.000},
				{954.735,279.646,10.000},
				{983.073,283.375,10.000},
				{1011.754,286.805,10.000},
				{1040.747,289.937,10.000},
				{1070.024,292.771,10.000},
				{1099.555,295.307,10.000},
				{1129.309,297.544,10.000},
				{1159.258,299.483,10.000},
				{1189.370,301.123,10.000},
				{1219.617,302.466,10.000},
				{1249.968,303.510,10.000},
				{1280.393,304.255,10.000},
				{1310.863,304.703,10.000},
				{1341.334,304.703,10.000},
				{1371.759,304.257,10.000},
				{1402.111,303.513,10.000},
				{1432.358,302.470,10.000},
				{1462.471,301.129,10.000},
				{1492.420,299.490,10.000},
				{1522.175,297.552,10.000},
				{1551.706,295.316,10.000},
				{1580.985,292.782,10.000},
				{1609.980,289.949,10.000},
				{1638.661,286.819,10.000},
				{1667.000,283.390,10.000},
				{1694.967,279.662,10.000},
				{1722.530,275.636,10.000},
				{1749.676,271.461,10.000},
				{1776.405,267.285,10.000},
				{1802.716,263.109,10.000},
				{1828.609,258.933,10.000},
				{1854.085,254.757,10.000},
				{1879.143,250.581,10.000},
				{1903.783,246.405,10.000},
				{1928.006,242.229,10.000},
				{1951.811,238.053,10.000},
				{1975.199,233.877,10.000},
				{1998.169,229.701,10.000},
				{2020.722,225.524,10.000},
				{2042.856,221.348,10.000},
				{2064.574,217.172,10.000},
				{2085.873,212.996,10.000},
				{2106.755,208.820,10.000},
				{2127.220,204.644,10.000},
				{2147.266,200.468,10.000},
				{2166.896,196.292,10.000},
				{2186.107,192.116,10.000},
				{2204.901,187.940,10.000},
				{2223.278,183.764,10.000},
				{2241.236,179.588,10.000},
				{2258.778,175.412,10.000},
				{2275.901,171.236,10.000},
				{2292.607,167.060,10.000},
				{2308.896,162.884,10.000},
				{2324.766,158.708,10.000},
				{2340.220,154.532,10.000},
				{2355.255,150.355,10.000},
				{2369.873,146.179,10.000},
				{2384.073,142.003,10.000},
				{2397.856,137.827,10.000},
				{2411.221,133.651,10.000},
				{2424.169,129.475,10.000},
				{2436.699,125.299,10.000},
				{2448.811,121.123,10.000},
				{2460.506,116.947,10.000},
				{2471.783,112.771,10.000},
				{2482.642,108.595,10.000},
				{2493.084,104.419,10.000},
				{2503.108,100.243,10.000},
				{2512.715,96.067,10.000},
				{2521.904,91.891,10.000},
				{2530.676,87.715,10.000},
				{2539.030,83.539,10.000},
				{2546.966,79.363,10.000},
				{2554.484,75.187,10.000},
				{2561.585,71.010,10.000},
				{2568.269,66.834,10.000},
				{2574.535,62.658,10.000},
				{2580.383,58.482,10.000},
				{2585.814,54.306,10.000},
				{2590.827,50.130,10.000},
				{2595.422,45.954,10.000},
				{2599.600,41.778,10.000},
				{2603.360,37.602,10.000},
				{2606.703,33.426,10.000},
				{2609.628,29.250,10.000},
				{2612.150,25.222,10.000},
				{2614.299,21.493,10.000},
				{2616.105,18.061,10.000},
				{2617.598,14.928,10.000},
				{2618.807,12.093,10.000},
				{2619.763,9.556,10.000},
				{2620.495,7.317,10.000},
				{2621.032,5.377,10.000},
				{2621.406,3.736,10.000},
				{2621.645,2.392,10.000},
				{2621.780,1.347,10.000},
				{2621.840,0.600,10.000},
				{2621.855,0.151,10.000},
				{2621.855,0.001,10.000},
				{2621.855,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.015,0.298,10.000},
				{0.075,0.597,10.000},
				{0.209,1.342,10.000},
				{0.447,2.386,10.000},
				{0.820,3.729,10.000},
				{1.357,5.369,10.000},
				{2.088,7.308,10.000},
				{3.043,9.545,10.000},
				{4.251,12.081,10.000},
				{5.742,14.914,10.000},
				{7.547,18.047,10.000},
				{9.694,21.477,10.000},
				{12.215,25.205,10.000},
				{15.138,29.232,10.000},
				{18.479,33.408,10.000},
				{22.237,37.584,10.000},
				{26.414,41.761,10.000},
				{31.007,45.937,10.000},
				{36.018,50.113,10.000},
				{41.447,54.289,10.000},
				{47.294,58.465,10.000},
				{53.558,62.641,10.000},
				{60.240,66.817,10.000},
				{67.339,70.993,10.000},
				{74.856,75.169,10.000},
				{82.790,79.345,10.000},
				{91.142,83.521,10.000},
				{99.912,87.697,10.000},
				{109.099,91.873,10.000},
				{118.704,96.049,10.000},
				{128.727,100.225,10.000},
				{139.167,104.401,10.000},
				{150.025,108.577,10.000},
				{161.300,112.753,10.000},
				{172.993,116.930,10.000},
				{185.104,121.106,10.000},
				{197.632,125.282,10.000},
				{210.578,129.458,10.000},
				{223.941,133.634,10.000},
				{237.722,137.810,10.000},
				{251.920,141.986,10.000},
				{266.537,146.162,10.000},
				{281.570,150.338,10.000},
				{297.022,154.514,10.000},
				{312.891,158.690,10.000},
				{329.177,162.866,10.000},
				{345.882,167.042,10.000},
				{363.004,171.218,10.000},
				{380.543,175.394,10.000},
				{398.500,179.570,10.000},
				{416.875,183.746,10.000},
				{435.667,187.922,10.000},
				{454.877,192.098,10.000},
				{474.504,196.275,10.000},
				{494.549,200.451,10.000},
				{515.012,204.627,10.000},
				{535.892,208.803,10.000},
				{557.190,212.979,10.000},
				{578.906,217.155,10.000},
				{601.039,221.331,10.000},
				{623.589,225.507,10.000},
				{646.558,229.683,10.000},
				{669.943,233.859,10.000},
				{693.747,238.035,10.000},
				{717.968,242.211,10.000},
				{742.607,246.387,10.000},
				{767.663,250.563,10.000},
				{793.137,254.739,10.000},
				{819.029,258.915,10.000},
				{845.338,263.091,10.000},
				{872.065,267.267,10.000},
				{899.209,271.444,10.000},
				{926.771,275.620,10.000},
				{954.735,279.646,10.000},
				{983.073,283.375,10.000},
				{1011.754,286.805,10.000},
				{1040.747,289.937,10.000},
				{1070.024,292.771,10.000},
				{1099.555,295.307,10.000},
				{1129.309,297.544,10.000},
				{1159.258,299.483,10.000},
				{1189.370,301.123,10.000},
				{1219.617,302.466,10.000},
				{1249.968,303.510,10.000},
				{1280.393,304.255,10.000},
				{1310.863,304.703,10.000},
				{1341.334,304.703,10.000},
				{1371.759,304.257,10.000},
				{1402.111,303.513,10.000},
				{1432.358,302.470,10.000},
				{1462.471,301.129,10.000},
				{1492.420,299.490,10.000},
				{1522.175,297.552,10.000},
				{1551.706,295.316,10.000},
				{1580.985,292.782,10.000},
				{1609.980,289.949,10.000},
				{1638.661,286.819,10.000},
				{1667.000,283.390,10.000},
				{1694.967,279.662,10.000},
				{1722.530,275.636,10.000},
				{1749.676,271.461,10.000},
				{1776.405,267.285,10.000},
				{1802.716,263.109,10.000},
				{1828.609,258.933,10.000},
				{1854.085,254.757,10.000},
				{1879.143,250.581,10.000},
				{1903.783,246.405,10.000},
				{1928.006,242.229,10.000},
				{1951.811,238.053,10.000},
				{1975.199,233.877,10.000},
				{1998.169,229.701,10.000},
				{2020.722,225.524,10.000},
				{2042.856,221.348,10.000},
				{2064.574,217.172,10.000},
				{2085.873,212.996,10.000},
				{2106.755,208.820,10.000},
				{2127.220,204.644,10.000},
				{2147.266,200.468,10.000},
				{2166.896,196.292,10.000},
				{2186.107,192.116,10.000},
				{2204.901,187.940,10.000},
				{2223.278,183.764,10.000},
				{2241.236,179.588,10.000},
				{2258.778,175.412,10.000},
				{2275.901,171.236,10.000},
				{2292.607,167.060,10.000},
				{2308.896,162.884,10.000},
				{2324.766,158.708,10.000},
				{2340.220,154.532,10.000},
				{2355.255,150.355,10.000},
				{2369.873,146.179,10.000},
				{2384.073,142.003,10.000},
				{2397.856,137.827,10.000},
				{2411.221,133.651,10.000},
				{2424.169,129.475,10.000},
				{2436.699,125.299,10.000},
				{2448.811,121.123,10.000},
				{2460.506,116.947,10.000},
				{2471.783,112.771,10.000},
				{2482.642,108.595,10.000},
				{2493.084,104.419,10.000},
				{2503.108,100.243,10.000},
				{2512.715,96.067,10.000},
				{2521.904,91.891,10.000},
				{2530.676,87.715,10.000},
				{2539.030,83.539,10.000},
				{2546.966,79.363,10.000},
				{2554.484,75.187,10.000},
				{2561.585,71.010,10.000},
				{2568.269,66.834,10.000},
				{2574.535,62.658,10.000},
				{2580.383,58.482,10.000},
				{2585.814,54.306,10.000},
				{2590.827,50.130,10.000},
				{2595.422,45.954,10.000},
				{2599.600,41.778,10.000},
				{2603.360,37.602,10.000},
				{2606.703,33.426,10.000},
				{2609.628,29.250,10.000},
				{2612.150,25.222,10.000},
				{2614.299,21.493,10.000},
				{2616.105,18.061,10.000},
				{2617.598,14.928,10.000},
				{2618.807,12.093,10.000},
				{2619.763,9.556,10.000},
				{2620.495,7.317,10.000},
				{2621.032,5.377,10.000},
				{2621.406,3.736,10.000},
				{2621.645,2.392,10.000},
				{2621.780,1.347,10.000},
				{2621.840,0.600,10.000},
				{2621.855,0.151,10.000},
				{2621.855,0.001,10.000},
				{2621.855,0.000,10.000}
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