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
				{0.014,0.271,10.000},
				{0.068,0.541,10.000},
				{0.190,1.218,10.000},
				{0.406,2.166,10.000},
				{0.744,3.384,10.000},
				{1.232,4.873,10.000},
				{1.895,6.633,10.000},
				{2.761,8.663,10.000},
				{3.858,10.964,10.000},
				{5.198,13.401,10.000},
				{6.782,15.837,10.000},
				{8.609,18.274,10.000},
				{10.680,20.710,10.000},
				{12.995,23.147,10.000},
				{15.553,25.583,10.000},
				{18.355,28.020,10.000},
				{21.400,30.456,10.000},
				{24.690,32.892,10.000},
				{28.223,35.329,10.000},
				{31.999,37.765,10.000},
				{36.019,40.202,10.000},
				{40.283,42.638,10.000},
				{44.791,45.075,10.000},
				{49.542,47.511,10.000},
				{54.537,49.948,10.000},
				{59.775,52.384,10.000},
				{65.257,54.821,10.000},
				{70.983,57.257,10.000},
				{76.952,59.694,10.000},
				{83.165,62.130,10.000},
				{89.622,64.567,10.000},
				{96.322,67.003,10.000},
				{103.266,69.440,10.000},
				{110.454,71.876,10.000},
				{117.885,74.313,10.000},
				{125.560,76.749,10.000},
				{133.478,79.186,10.000},
				{141.641,81.622,10.000},
				{150.046,84.059,10.000},
				{158.696,86.495,10.000},
				{167.589,88.931,10.000},
				{176.726,91.368,10.000},
				{186.106,93.804,10.000},
				{195.730,96.241,10.000},
				{205.598,98.677,10.000},
				{215.710,101.114,10.000},
				{226.065,103.550,10.000},
				{236.663,105.987,10.000},
				{247.506,108.423,10.000},
				{258.592,110.860,10.000},
				{269.921,113.296,10.000},
				{281.495,115.733,10.000},
				{293.311,118.169,10.000},
				{305.372,120.606,10.000},
				{317.676,123.042,10.000},
				{330.224,125.479,10.000},
				{343.016,127.915,10.000},
				{356.051,130.352,10.000},
				{369.330,132.788,10.000},
				{382.852,135.225,10.000},
				{396.618,137.661,10.000},
				{410.628,140.098,10.000},
				{424.881,142.534,10.000},
				{439.378,144.970,10.000},
				{454.119,147.407,10.000},
				{469.103,149.843,10.000},
				{484.331,152.280,10.000},
				{499.803,154.716,10.000},
				{515.518,157.153,10.000},
				{531.477,159.589,10.000},
				{547.680,162.026,10.000},
				{564.126,164.462,10.000},
				{580.816,166.899,10.000},
				{597.749,169.335,10.000},
				{614.927,171.772,10.000},
				{632.347,174.208,10.000},
				{650.012,176.645,10.000},
				{667.920,179.081,10.000},
				{686.072,181.518,10.000},
				{704.467,183.954,10.000},
				{723.106,186.391,10.000},
				{741.989,188.827,10.000},
				{761.115,191.264,10.000},
				{780.485,193.700,10.000},
				{800.099,196.137,10.000},
				{819.956,198.573,10.000},
				{840.057,201.010,10.000},
				{860.402,203.446,10.000},
				{880.990,205.882,10.000},
				{901.822,208.319,10.000},
				{922.898,210.755,10.000},
				{944.217,213.192,10.000},
				{965.780,215.628,10.000},
				{987.586,218.065,10.000},
				{1009.636,220.501,10.000},
				{1031.930,222.938,10.000},
				{1054.454,225.239,10.000},
				{1077.181,227.269,10.000},
				{1100.084,229.029,10.000},
				{1123.136,230.518,10.000},
				{1146.309,231.736,10.000},
				{1169.578,232.684,10.000},
				{1192.914,233.361,10.000},
				{1216.290,233.767,10.000},
				{1239.670,233.801,10.000},
				{1263.017,233.463,10.000},
				{1286.302,232.855,10.000},
				{1309.500,231.976,10.000},
				{1332.583,230.827,10.000},
				{1355.523,229.406,10.000},
				{1378.295,227.715,10.000},
				{1400.870,225.754,10.000},
				{1423.222,223.521,10.000},
				{1445.334,221.119,10.000},
				{1467.202,218.682,10.000},
				{1488.827,216.246,10.000},
				{1510.208,213.809,10.000},
				{1531.345,211.373,10.000},
				{1552.239,208.936,10.000},
				{1572.889,206.500,10.000},
				{1593.295,204.063,10.000},
				{1613.458,201.627,10.000},
				{1633.377,199.191,10.000},
				{1653.052,196.754,10.000},
				{1672.484,194.318,10.000},
				{1691.672,191.881,10.000},
				{1710.617,189.445,10.000},
				{1729.317,187.008,10.000},
				{1747.775,184.572,10.000},
				{1765.988,182.135,10.000},
				{1783.958,179.699,10.000},
				{1801.684,177.262,10.000},
				{1819.167,174.826,10.000},
				{1836.406,172.389,10.000},
				{1853.401,169.953,10.000},
				{1870.153,167.516,10.000},
				{1886.660,165.080,10.000},
				{1902.925,162.643,10.000},
				{1918.946,160.207,10.000},
				{1934.723,157.770,10.000},
				{1950.256,155.334,10.000},
				{1965.546,152.897,10.000},
				{1980.592,150.461,10.000},
				{1995.394,148.024,10.000},
				{2009.953,145.588,10.000},
				{2024.268,143.152,10.000},
				{2038.340,140.715,10.000},
				{2052.168,138.279,10.000},
				{2065.752,135.842,10.000},
				{2079.092,133.406,10.000},
				{2092.189,130.969,10.000},
				{2105.042,128.533,10.000},
				{2117.652,126.096,10.000},
				{2130.018,123.660,10.000},
				{2142.140,121.223,10.000},
				{2154.019,118.787,10.000},
				{2165.654,116.350,10.000},
				{2177.045,113.914,10.000},
				{2188.193,111.477,10.000},
				{2199.097,109.041,10.000},
				{2209.758,106.604,10.000},
				{2220.174,104.168,10.000},
				{2230.348,101.731,10.000},
				{2240.277,99.295,10.000},
				{2249.963,96.858,10.000},
				{2259.405,94.422,10.000},
				{2268.604,91.985,10.000},
				{2277.559,89.549,10.000},
				{2286.270,87.112,10.000},
				{2294.737,84.676,10.000},
				{2302.961,82.240,10.000},
				{2310.942,79.803,10.000},
				{2318.678,77.367,10.000},
				{2326.171,74.930,10.000},
				{2333.421,72.494,10.000},
				{2340.426,70.057,10.000},
				{2347.188,67.621,10.000},
				{2353.707,65.184,10.000},
				{2359.982,62.748,10.000},
				{2366.013,60.311,10.000},
				{2371.800,57.875,10.000},
				{2377.344,55.438,10.000},
				{2382.644,53.002,10.000},
				{2387.701,50.565,10.000},
				{2392.514,48.129,10.000},
				{2397.083,45.692,10.000},
				{2401.408,43.256,10.000},
				{2405.490,40.819,10.000},
				{2409.329,38.383,10.000},
				{2412.923,35.946,10.000},
				{2416.274,33.510,10.000},
				{2419.382,31.073,10.000},
				{2422.245,28.637,10.000},
				{2424.865,26.201,10.000},
				{2427.242,23.764,10.000},
				{2429.375,21.328,10.000},
				{2431.264,18.891,10.000},
				{2432.909,16.455,10.000},
				{2434.311,14.018,10.000},
				{2435.469,11.582,10.000},
				{2436.394,9.246,10.000},
				{2437.109,7.147,10.000},
				{2437.640,5.319,10.000},
				{2438.017,3.761,10.000},
				{2438.264,2.475,10.000},
				{2438.410,1.458,10.000},
				{2438.481,0.713,10.000},
				{2438.505,0.238,10.000},
				{2438.508,0.034,10.000},
				{2438.508,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.014,0.271,10.000},
				{0.068,0.541,10.000},
				{0.190,1.218,10.000},
				{0.406,2.166,10.000},
				{0.744,3.384,10.000},
				{1.232,4.873,10.000},
				{1.895,6.633,10.000},
				{2.761,8.663,10.000},
				{3.858,10.964,10.000},
				{5.198,13.401,10.000},
				{6.782,15.837,10.000},
				{8.609,18.274,10.000},
				{10.680,20.710,10.000},
				{12.995,23.147,10.000},
				{15.553,25.583,10.000},
				{18.355,28.020,10.000},
				{21.400,30.456,10.000},
				{24.690,32.892,10.000},
				{28.223,35.329,10.000},
				{31.999,37.765,10.000},
				{36.019,40.202,10.000},
				{40.283,42.638,10.000},
				{44.791,45.075,10.000},
				{49.542,47.511,10.000},
				{54.537,49.948,10.000},
				{59.775,52.384,10.000},
				{65.257,54.821,10.000},
				{70.983,57.257,10.000},
				{76.952,59.694,10.000},
				{83.165,62.130,10.000},
				{89.622,64.567,10.000},
				{96.322,67.003,10.000},
				{103.266,69.440,10.000},
				{110.454,71.876,10.000},
				{117.885,74.313,10.000},
				{125.560,76.749,10.000},
				{133.478,79.186,10.000},
				{141.641,81.622,10.000},
				{150.046,84.059,10.000},
				{158.696,86.495,10.000},
				{167.589,88.931,10.000},
				{176.726,91.368,10.000},
				{186.106,93.804,10.000},
				{195.730,96.241,10.000},
				{205.598,98.677,10.000},
				{215.710,101.114,10.000},
				{226.065,103.550,10.000},
				{236.663,105.987,10.000},
				{247.506,108.423,10.000},
				{258.592,110.860,10.000},
				{269.921,113.296,10.000},
				{281.495,115.733,10.000},
				{293.311,118.169,10.000},
				{305.372,120.606,10.000},
				{317.676,123.042,10.000},
				{330.224,125.479,10.000},
				{343.016,127.915,10.000},
				{356.051,130.352,10.000},
				{369.330,132.788,10.000},
				{382.852,135.225,10.000},
				{396.618,137.661,10.000},
				{410.628,140.098,10.000},
				{424.881,142.534,10.000},
				{439.378,144.970,10.000},
				{454.119,147.407,10.000},
				{469.103,149.843,10.000},
				{484.331,152.280,10.000},
				{499.803,154.716,10.000},
				{515.518,157.153,10.000},
				{531.477,159.589,10.000},
				{547.680,162.026,10.000},
				{564.126,164.462,10.000},
				{580.816,166.899,10.000},
				{597.749,169.335,10.000},
				{614.927,171.772,10.000},
				{632.347,174.208,10.000},
				{650.012,176.645,10.000},
				{667.920,179.081,10.000},
				{686.072,181.518,10.000},
				{704.467,183.954,10.000},
				{723.106,186.391,10.000},
				{741.989,188.827,10.000},
				{761.115,191.264,10.000},
				{780.485,193.700,10.000},
				{800.099,196.137,10.000},
				{819.956,198.573,10.000},
				{840.057,201.010,10.000},
				{860.402,203.446,10.000},
				{880.990,205.882,10.000},
				{901.822,208.319,10.000},
				{922.898,210.755,10.000},
				{944.217,213.192,10.000},
				{965.780,215.628,10.000},
				{987.586,218.065,10.000},
				{1009.636,220.501,10.000},
				{1031.930,222.938,10.000},
				{1054.454,225.239,10.000},
				{1077.181,227.269,10.000},
				{1100.084,229.029,10.000},
				{1123.136,230.518,10.000},
				{1146.309,231.736,10.000},
				{1169.578,232.684,10.000},
				{1192.914,233.361,10.000},
				{1216.290,233.767,10.000},
				{1239.670,233.801,10.000},
				{1263.017,233.463,10.000},
				{1286.302,232.855,10.000},
				{1309.500,231.976,10.000},
				{1332.583,230.827,10.000},
				{1355.523,229.406,10.000},
				{1378.295,227.715,10.000},
				{1400.870,225.754,10.000},
				{1423.222,223.521,10.000},
				{1445.334,221.119,10.000},
				{1467.202,218.682,10.000},
				{1488.827,216.246,10.000},
				{1510.208,213.809,10.000},
				{1531.345,211.373,10.000},
				{1552.239,208.936,10.000},
				{1572.889,206.500,10.000},
				{1593.295,204.063,10.000},
				{1613.458,201.627,10.000},
				{1633.377,199.191,10.000},
				{1653.052,196.754,10.000},
				{1672.484,194.318,10.000},
				{1691.672,191.881,10.000},
				{1710.617,189.445,10.000},
				{1729.317,187.008,10.000},
				{1747.775,184.572,10.000},
				{1765.988,182.135,10.000},
				{1783.958,179.699,10.000},
				{1801.684,177.262,10.000},
				{1819.167,174.826,10.000},
				{1836.406,172.389,10.000},
				{1853.401,169.953,10.000},
				{1870.153,167.516,10.000},
				{1886.660,165.080,10.000},
				{1902.925,162.643,10.000},
				{1918.946,160.207,10.000},
				{1934.723,157.770,10.000},
				{1950.256,155.334,10.000},
				{1965.546,152.897,10.000},
				{1980.592,150.461,10.000},
				{1995.394,148.024,10.000},
				{2009.953,145.588,10.000},
				{2024.268,143.152,10.000},
				{2038.340,140.715,10.000},
				{2052.168,138.279,10.000},
				{2065.752,135.842,10.000},
				{2079.092,133.406,10.000},
				{2092.189,130.969,10.000},
				{2105.042,128.533,10.000},
				{2117.652,126.096,10.000},
				{2130.018,123.660,10.000},
				{2142.140,121.223,10.000},
				{2154.019,118.787,10.000},
				{2165.654,116.350,10.000},
				{2177.045,113.914,10.000},
				{2188.193,111.477,10.000},
				{2199.097,109.041,10.000},
				{2209.758,106.604,10.000},
				{2220.174,104.168,10.000},
				{2230.348,101.731,10.000},
				{2240.277,99.295,10.000},
				{2249.963,96.858,10.000},
				{2259.405,94.422,10.000},
				{2268.604,91.985,10.000},
				{2277.559,89.549,10.000},
				{2286.270,87.112,10.000},
				{2294.737,84.676,10.000},
				{2302.961,82.240,10.000},
				{2310.942,79.803,10.000},
				{2318.678,77.367,10.000},
				{2326.171,74.930,10.000},
				{2333.421,72.494,10.000},
				{2340.426,70.057,10.000},
				{2347.188,67.621,10.000},
				{2353.707,65.184,10.000},
				{2359.982,62.748,10.000},
				{2366.013,60.311,10.000},
				{2371.800,57.875,10.000},
				{2377.344,55.438,10.000},
				{2382.644,53.002,10.000},
				{2387.701,50.565,10.000},
				{2392.514,48.129,10.000},
				{2397.083,45.692,10.000},
				{2401.408,43.256,10.000},
				{2405.490,40.819,10.000},
				{2409.329,38.383,10.000},
				{2412.923,35.946,10.000},
				{2416.274,33.510,10.000},
				{2419.382,31.073,10.000},
				{2422.245,28.637,10.000},
				{2424.865,26.201,10.000},
				{2427.242,23.764,10.000},
				{2429.375,21.328,10.000},
				{2431.264,18.891,10.000},
				{2432.909,16.455,10.000},
				{2434.311,14.018,10.000},
				{2435.469,11.582,10.000},
				{2436.394,9.246,10.000},
				{2437.109,7.147,10.000},
				{2437.640,5.319,10.000},
				{2438.017,3.761,10.000},
				{2438.264,2.475,10.000},
				{2438.410,1.458,10.000},
				{2438.481,0.713,10.000},
				{2438.505,0.238,10.000},
				{2438.508,0.034,10.000},
				{2438.508,0.000,10.000}
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