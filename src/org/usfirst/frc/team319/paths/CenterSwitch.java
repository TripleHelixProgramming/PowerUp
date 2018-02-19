package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class CenterSwitch extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.75,0.00,0.00)
	// (11.67,5.00,0.00)
	
	public CenterSwitch() {
		this(false);
	}
			
    public CenterSwitch(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.014,0.271,10.000},
				{0.068,0.542,10.000},
				{0.190,1.219,10.000},
				{0.406,2.167,10.000},
				{0.745,3.386,10.000},
				{1.232,4.875,10.000},
				{1.896,6.633,10.000},
				{2.762,8.661,10.000},
				{3.858,10.957,10.000},
				{5.196,13.384,10.000},
				{6.777,15.807,10.000},
				{8.599,18.225,10.000},
				{10.663,20.637,10.000},
				{12.967,23.042,10.000},
				{15.511,25.440,10.000},
				{18.294,27.829,10.000},
				{21.315,30.209,10.000},
				{24.573,32.579,10.000},
				{28.067,34.939,10.000},
				{31.796,37.288,10.000},
				{35.758,39.625,10.000},
				{39.953,41.949,10.000},
				{44.379,44.259,10.000},
				{49.034,46.556,10.000},
				{53.918,48.838,10.000},
				{59.029,51.105,10.000},
				{64.364,53.356,10.000},
				{69.923,55.590,10.000},
				{75.704,57.807,10.000},
				{81.704,60.006,10.000},
				{87.923,62.187,10.000},
				{94.358,64.348,10.000},
				{101.007,66.490,10.000},
				{107.868,68.612,10.000},
				{114.940,70.714,10.000},
				{122.219,72.794,10.000},
				{129.704,74.852,10.000},
				{137.393,76.888,10.000},
				{145.283,78.901,10.000},
				{153.372,80.890,10.000},
				{161.658,82.855,10.000},
				{170.137,84.796,10.000},
				{178.808,86.712,10.000},
				{187.668,88.601,10.000},
				{196.715,90.465,10.000},
				{205.945,92.302,10.000},
				{215.356,94.112,10.000},
				{224.946,95.893,10.000},
				{234.710,97.646,10.000},
				{244.647,99.370,10.000},
				{254.754,101.065,10.000},
				{265.027,102.729,10.000},
				{275.463,104.362,10.000},
				{286.059,105.963,10.000},
				{296.812,107.533,10.000},
				{307.719,109.070,10.000},
				{318.777,110.573,10.000},
				{329.981,112.042,10.000},
				{341.329,113.477,10.000},
				{352.816,114.877,10.000},
				{364.440,116.241,10.000},
				{376.197,117.568,10.000},
				{388.083,118.858,10.000},
				{400.094,120.111,10.000},
				{412.227,121.326,10.000},
				{424.477,122.502,10.000},
				{436.841,123.639,10.000},
				{449.314,124.736,10.000},
				{461.894,125.794,10.000},
				{474.575,126.812,10.000},
				{487.354,127.790,10.000},
				{500.227,128.728,10.000},
				{513.189,129.625,10.000},
				{526.238,130.483,10.000},
				{539.368,131.302,10.000},
				{552.576,132.082,10.000},
				{565.858,132.824,10.000},
				{579.211,133.530,10.000},
				{592.631,134.200,10.000},
				{606.115,134.836,10.000},
				{619.659,135.441,10.000},
				{633.261,136.017,10.000},
				{646.917,136.565,10.000},
				{660.626,137.091,10.000},
				{674.386,137.597,10.000},
				{688.195,138.087,10.000},
				{702.051,138.566,10.000},
				{715.955,139.040,10.000},
				{729.907,139.513,10.000},
				{743.906,139.993,10.000},
				{757.955,140.486,10.000},
				{772.054,140.999,10.000},
				{786.209,141.540,10.000},
				{800.420,142.119,10.000},
				{814.695,142.743,10.000},
				{829.037,143.422,10.000},
				{843.454,144.166,10.000},
				{857.952,144.985,10.000},
				{872.541,145.888,10.000},
				{887.229,146.886,10.000},
				{902.028,147.989,10.000},
				{916.949,149.206,10.000},
				{932.004,150.548,10.000},
				{947.206,152.022,10.000},
				{962.570,153.639,10.000},
				{978.110,155.403,10.000},
				{993.843,157.324,10.000},
				{1009.783,159.406,10.000},
				{1025.948,161.653,10.000},
				{1042.355,164.069,10.000},
				{1059.021,166.655,10.000},
				{1075.962,169.413,10.000},
				{1093.196,172.342,10.000},
				{1110.740,175.440,10.000},
				{1128.611,178.704,10.000},
				{1146.824,182.130,10.000},
				{1165.395,185.712,10.000},
				{1184.339,189.444,10.000},
				{1203.671,193.320,10.000},
				{1223.405,197.332,10.000},
				{1243.552,201.472,10.000},
				{1264.125,205.731,10.000},
				{1285.135,210.101,10.000},
				{1306.592,214.574,10.000},
				{1328.506,219.140,10.000},
				{1350.885,223.791,10.000},
				{1373.738,228.521,10.000},
				{1397.069,233.319,10.000},
				{1420.888,238.181,10.000},
				{1445.197,243.098,10.000},
				{1470.004,248.064,10.000},
				{1495.311,253.075,10.000},
				{1521.124,258.126,10.000},
				{1547.445,263.211,10.000},
				{1574.278,268.328,10.000},
				{1601.625,273.474,10.000},
				{1629.490,278.647,10.000},
				{1657.874,283.844,10.000},
				{1686.781,289.065,10.000},
				{1716.212,294.310,10.000},
				{1746.158,299.457,10.000},
				{1776.595,304.376,10.000},
				{1807.501,309.061,10.000},
				{1838.851,313.502,10.000},
				{1870.621,317.694,10.000},
				{1902.784,321.628,10.000},
				{1935.314,325.301,10.000},
				{1968.184,328.704,10.000},
				{2001.368,331.835,10.000},
				{2034.850,334.820,10.000},
				{2068.629,337.795,10.000},
				{2102.705,340.764,10.000},
				{2137.079,343.732,10.000},
				{2171.749,346.703,10.000},
				{2206.717,349.683,10.000},
				{2241.977,352.596,10.000},
				{2277.507,355.300,10.000},
				{2313.280,357.733,10.000},
				{2349.269,359.890,10.000},
				{2385.445,361.763,10.000},
				{2421.780,363.348,10.000},
				{2458.244,364.637,10.000},
				{2494.806,365.622,10.000},
				{2531.436,366.296,10.000},
				{2568.109,366.737,10.000},
				{2604.818,367.091,10.000},
				{2641.561,367.421,10.000},
				{2678.333,367.727,10.000},
				{2715.134,368.007,10.000},
				{2751.960,368.260,10.000},
				{2788.808,368.482,10.000},
				{2825.675,368.670,10.000},
				{2862.557,368.821,10.000},
				{2899.450,368.930,10.000},
				{2936.349,368.991,10.000},
				{2973.249,369.000,10.000},
				{3010.144,368.949,10.000},
				{3047.027,368.831,10.000},
				{3083.891,368.639,10.000},
				{3120.728,368.365,10.000},
				{3157.528,368.001,10.000},
				{3194.282,367.539,10.000},
				{3230.979,366.969,10.000},
				{3267.607,366.283,10.000},
				{3304.154,365.473,10.000},
				{3340.607,364.530,10.000},
				{3376.952,363.447,10.000},
				{3413.173,362.216,10.000},
				{3449.257,360.832,10.000},
				{3485.185,359.288,10.000},
				{3520.943,357.580,10.000},
				{3556.514,355.704,10.000},
				{3591.879,353.657,10.000},
				{3627.023,351.440,10.000},
				{3661.929,349.051,10.000},
				{3696.578,346.492,10.000},
				{3730.954,343.767,10.000},
				{3765.042,340.878,10.000},
				{3798.825,337.831,10.000},
				{3832.289,334.633,10.000},
				{3865.417,331.289,10.000},
				{3898.198,327.809,10.000},
				{3930.619,324.202,10.000},
				{3962.666,320.475,10.000},
				{3994.330,316.640,10.000},
				{4025.601,312.705,10.000},
				{4056.469,308.681,10.000},
				{4086.927,304.579,10.000},
				{4116.967,300.408,10.000},
				{4146.585,296.177,10.000},
				{4175.775,291.897,10.000},
				{4204.532,287.576,10.000},
				{4232.855,283.224,10.000},
				{4260.740,278.848,10.000},
				{4288.185,274.455,10.000},
				{4315.190,270.054,10.000},
				{4341.755,265.650,10.000},
				{4367.880,261.249,10.000},
				{4393.566,256.857,10.000},
				{4418.814,252.479,10.000},
				{4443.626,248.119,10.000},
				{4468.004,243.780,10.000},
				{4491.951,239.467,10.000},
				{4515.469,235.182,10.000},
				{4538.562,230.928,10.000},
				{4561.232,226.707,10.000},
				{4583.484,222.520,10.000},
				{4605.321,218.370,10.000},
				{4626.747,214.257,10.000},
				{4647.765,210.182,10.000},
				{4668.380,206.147,10.000},
				{4688.595,202.150,10.000},
				{4708.414,198.194,10.000},
				{4727.842,194.278,10.000},
				{4746.882,190.402,10.000},
				{4765.539,186.566,10.000},
				{4783.816,182.770,10.000},
				{4801.717,179.013,10.000},
				{4819.247,175.296,10.000},
				{4836.409,171.617,10.000},
				{4853.206,167.977,10.000},
				{4869.644,164.374,10.000},
				{4885.725,160.809,10.000},
				{4901.453,157.280,10.000},
				{4916.831,153.788,10.000},
				{4931.865,150.331,10.000},
				{4946.555,146.909,10.000},
				{4960.908,143.521,10.000},
				{4974.924,140.167,10.000},
				{4988.609,136.845,10.000},
				{5001.964,133.556,10.000},
				{5014.994,130.299,10.000},
				{5027.702,127.073,10.000},
				{5040.089,123.878,10.000},
				{5052.161,120.712,10.000},
				{5063.918,117.576,10.000},
				{5075.365,114.469,10.000},
				{5086.504,111.389,10.000},
				{5097.338,108.338,10.000},
				{5107.869,105.313,10.000},
				{5118.101,102.315,10.000},
				{5128.035,99.343,10.000},
				{5137.674,96.396,10.000},
				{5147.022,93.474,10.000},
				{5156.079,90.576,10.000},
				{5164.850,87.702,10.000},
				{5173.335,84.851,10.000},
				{5181.537,82.023,10.000},
				{5189.459,79.217,10.000},
				{5197.102,76.432,10.000},
				{5204.469,73.668,10.000},
				{5211.561,70.925,10.000},
				{5218.381,68.201,10.000},
				{5224.931,65.497,10.000},
				{5231.212,62.811,10.000},
				{5237.227,60.144,10.000},
				{5242.976,57.494,10.000},
				{5248.462,54.861,10.000},
				{5253.686,52.244,10.000},
				{5258.651,49.642,10.000},
				{5263.356,47.056,10.000},
				{5267.805,44.484,10.000},
				{5271.997,41.925,10.000},
				{5275.935,39.379,10.000},
				{5279.620,36.846,10.000},
				{5283.052,34.324,10.000},
				{5286.233,31.813,10.000},
				{5289.165,29.312,10.000},
				{5291.847,26.821,10.000},
				{5294.280,24.338,10.000},
				{5296.467,21.863,10.000},
				{5298.406,19.395,10.000},
				{5300.099,16.933,10.000},
				{5301.547,14.477,10.000},
				{5302.750,12.025,10.000},
				{5303.715,9.656,10.000},
				{5304.466,7.504,10.000},
				{5305.028,5.625,10.000},
				{5305.430,4.018,10.000},
				{5305.698,2.684,10.000},
				{5305.860,1.621,10.000},
				{5305.943,0.828,10.000},
				{5305.974,0.307,10.000},
				{5305.980,0.057,10.000},
				{5305.980,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.014,0.271,10.000},
				{0.068,0.542,10.000},
				{0.190,1.219,10.000},
				{0.406,2.168,10.000},
				{0.745,3.388,10.000},
				{1.233,4.879,10.000},
				{1.897,6.643,10.000},
				{2.765,8.679,10.000},
				{3.864,10.990,10.000},
				{5.208,13.439,10.000},
				{6.798,15.893,10.000},
				{8.633,18.352,10.000},
				{10.715,20.818,10.000},
				{13.044,23.290,10.000},
				{15.620,25.769,10.000},
				{18.446,28.257,10.000},
				{21.522,30.754,10.000},
				{24.848,33.260,10.000},
				{28.425,35.777,10.000},
				{32.256,38.306,10.000},
				{36.341,40.846,10.000},
				{40.680,43.399,10.000},
				{45.277,45.965,10.000},
				{50.132,48.546,10.000},
				{55.246,51.141,10.000},
				{60.621,53.751,10.000},
				{66.258,56.377,10.000},
				{72.161,59.020,10.000},
				{78.329,61.680,10.000},
				{84.764,64.358,10.000},
				{91.470,67.054,10.000},
				{98.447,69.770,10.000},
				{105.697,72.505,10.000},
				{113.223,75.260,10.000},
				{121.027,78.035,10.000},
				{129.110,80.832,10.000},
				{137.475,83.651,10.000},
				{146.124,86.492,10.000},
				{155.060,89.357,10.000},
				{164.284,92.244,10.000},
				{173.800,95.156,10.000},
				{183.609,98.092,10.000},
				{193.715,101.054,10.000},
				{204.119,104.041,10.000},
				{214.824,107.054,10.000},
				{225.833,110.094,10.000},
				{237.150,113.162,10.000},
				{248.775,116.257,10.000},
				{260.713,119.381,10.000},
				{272.967,122.534,10.000},
				{285.538,125.717,10.000},
				{298.431,128.930,10.000},
				{311.649,132.174,10.000},
				{325.194,135.449,10.000},
				{339.069,138.756,10.000},
				{353.279,142.097,10.000},
				{367.826,145.470,10.000},
				{382.714,148.878,10.000},
				{397.946,152.320,10.000},
				{413.526,155.797,10.000},
				{429.457,159.311,10.000},
				{445.743,162.860,10.000},
				{462.387,166.447,10.000},
				{479.394,170.071,10.000},
				{496.768,173.734,10.000},
				{514.511,177.435,10.000},
				{532.629,181.174,10.000},
				{551.124,184.954,10.000},
				{570.001,188.773,10.000},
				{589.265,192.632,10.000},
				{608.918,196.531,10.000},
				{628.965,200.470,10.000},
				{649.410,204.450,10.000},
				{670.257,208.469,10.000},
				{691.509,212.527,10.000},
				{713.172,216.624,10.000},
				{735.247,220.759,10.000},
				{757.740,224.930,10.000},
				{780.654,229.137,10.000},
				{803.992,233.377,10.000},
				{827.757,237.649,10.000},
				{851.952,241.951,10.000},
				{876.580,246.279,10.000},
				{901.643,250.630,10.000},
				{927.143,255.001,10.000},
				{953.082,259.388,10.000},
				{979.460,263.786,10.000},
				{1006.279,268.189,10.000},
				{1033.539,272.592,10.000},
				{1061.238,276.990,10.000},
				{1089.375,281.374,10.000},
				{1117.949,285.737,10.000},
				{1146.956,290.073,10.000},
				{1176.393,294.371,10.000},
				{1206.255,298.624,10.000},
				{1236.537,302.821,10.000},
				{1267.233,306.954,10.000},
				{1298.334,311.013,10.000},
				{1329.833,314.986,10.000},
				{1361.719,318.865,10.000},
				{1393.983,322.639,10.000},
				{1426.613,326.298,10.000},
				{1459.596,329.834,10.000},
				{1492.920,333.236,10.000},
				{1526.570,336.497,10.000},
				{1560.530,339.609,10.000},
				{1594.787,342.565,10.000},
				{1629.323,345.360,10.000},
				{1664.122,347.990,10.000},
				{1699.167,350.451,10.000},
				{1734.441,352.741,10.000},
				{1769.927,354.860,10.000},
				{1805.608,356.808,10.000},
				{1841.467,358.587,10.000},
				{1877.487,360.201,10.000},
				{1913.652,361.652,10.000},
				{1949.947,362.947,10.000},
				{1986.356,364.092,10.000},
				{2022.865,365.093,10.000},
				{2059.461,365.958,10.000},
				{2096.131,366.696,10.000},
				{2132.862,367.314,10.000},
				{2169.644,367.821,10.000},
				{2206.467,368.226,10.000},
				{2243.320,368.537,10.000},
				{2280.197,368.762,10.000},
				{2317.088,368.910,10.000},
				{2353.987,368.989,10.000},
				{2390.887,369.005,10.000},
				{2427.783,368.965,10.000},
				{2464.671,368.875,10.000},
				{2501.545,368.742,10.000},
				{2538.402,368.569,10.000},
				{2575.238,368.360,10.000},
				{2612.050,368.120,10.000},
				{2648.835,367.852,10.000},
				{2685.591,367.556,10.000},
				{2722.315,367.236,10.000},
				{2759.004,366.892,10.000},
				{2795.656,366.524,10.000},
				{2832.255,365.984,10.000},
				{2868.767,365.129,10.000},
				{2905.164,363.967,10.000},
				{2941.415,362.506,10.000},
				{2977.490,360.753,10.000},
				{3013.362,358.715,10.000},
				{3049.001,356.398,10.000},
				{3084.382,353.807,10.000},
				{3119.477,350.948,10.000},
				{3154.273,347.962,10.000},
				{3188.772,344.988,10.000},
				{3222.974,342.019,10.000},
				{3256.879,339.051,10.000},
				{3290.487,336.079,10.000},
				{3323.797,333.099,10.000},
				{3356.800,330.030,10.000},
				{3389.474,326.742,10.000},
				{3421.792,323.183,10.000},
				{3453.728,319.360,10.000},
				{3485.256,315.276,10.000},
				{3516.350,310.940,10.000},
				{3546.986,306.358,10.000},
				{3577.139,301.538,10.000},
				{3606.788,296.487,10.000},
				{3635.917,291.284,10.000},
				{3664.522,286.052,10.000},
				{3692.606,280.845,10.000},
				{3720.173,275.662,10.000},
				{3747.223,270.505,10.000},
				{3773.760,265.375,10.000},
				{3799.788,260.276,10.000},
				{3825.309,255.210,10.000},
				{3850.327,250.182,10.000},
				{3874.847,245.196,10.000},
				{3898.872,240.257,10.000},
				{3922.410,235.371,10.000},
				{3945.464,230.545,10.000},
				{3968.043,225.786,10.000},
				{3990.153,221.100,10.000},
				{4011.802,216.497,10.000},
				{4033.001,211.984,10.000},
				{4053.758,207.569,10.000},
				{4074.084,203.262,10.000},
				{4093.991,199.070,10.000},
				{4113.491,195.003,10.000},
				{4132.598,191.069,10.000},
				{4151.326,187.275,10.000},
				{4169.688,183.628,10.000},
				{4187.702,180.136,10.000},
				{4205.382,176.803,10.000},
				{4222.746,173.634,10.000},
				{4239.809,170.633,10.000},
				{4256.589,167.802,10.000},
				{4273.103,165.143,10.000},
				{4289.369,162.655,10.000},
				{4305.402,160.336,10.000},
				{4321.221,158.185,10.000},
				{4336.841,156.197,10.000},
				{4352.277,154.367,10.000},
				{4367.546,152.688,10.000},
				{4382.662,151.155,10.000},
				{4397.637,149.758,10.000},
				{4412.486,148.489,10.000},
				{4427.220,147.338,10.000},
				{4441.850,146.297,10.000},
				{4456.385,145.355,10.000},
				{4470.836,144.502,10.000},
				{4485.208,143.727,10.000},
				{4499.510,143.022,10.000},
				{4513.748,142.375,10.000},
				{4527.926,141.779,10.000},
				{4542.048,141.222,10.000},
				{4556.118,140.698,10.000},
				{4570.138,140.198,10.000},
				{4584.109,139.713,10.000},
				{4598.033,139.238,10.000},
				{4611.909,138.765,10.000},
				{4625.738,138.289,10.000},
				{4639.519,137.804,10.000},
				{4653.249,137.305,10.000},
				{4666.928,136.788,10.000},
				{4680.553,136.250,10.000},
				{4694.122,135.686,10.000},
				{4707.631,135.094,10.000},
				{4721.078,134.471,10.000},
				{4734.460,133.816,10.000},
				{4747.772,133.125,10.000},
				{4761.012,132.399,10.000},
				{4774.176,131.635,10.000},
				{4787.259,130.833,10.000},
				{4800.258,129.991,10.000},
				{4813.169,129.110,10.000},
				{4825.988,128.190,10.000},
				{4838.711,127.229,10.000},
				{4851.334,126.228,10.000},
				{4863.852,125.187,10.000},
				{4876.263,124.106,10.000},
				{4888.561,122.986,10.000},
				{4900.744,121.826,10.000},
				{4912.807,120.628,10.000},
				{4924.746,119.391,10.000},
				{4936.558,118.117,10.000},
				{4948.238,116.805,10.000},
				{4959.784,115.457,10.000},
				{4971.191,114.072,10.000},
				{4982.456,112.652,10.000},
				{4993.576,111.197,10.000},
				{5004.547,109.708,10.000},
				{5015.365,108.185,10.000},
				{5026.028,106.630,10.000},
				{5036.533,105.042,10.000},
				{5046.875,103.422,10.000},
				{5057.052,101.771,10.000},
				{5067.061,100.089,10.000},
				{5076.898,98.378,10.000},
				{5086.562,96.637,10.000},
				{5096.049,94.867,10.000},
				{5105.356,93.070,10.000},
				{5114.480,91.244,10.000},
				{5123.419,89.392,10.000},
				{5132.171,87.513,10.000},
				{5140.732,85.608,10.000},
				{5149.099,83.678,10.000},
				{5157.272,81.723,10.000},
				{5165.246,79.744,10.000},
				{5173.020,77.741,10.000},
				{5180.592,75.715,10.000},
				{5187.958,73.666,10.000},
				{5195.118,71.595,10.000},
				{5202.068,69.503,10.000},
				{5208.807,67.390,10.000},
				{5215.333,65.256,10.000},
				{5221.643,63.102,10.000},
				{5227.736,60.930,10.000},
				{5233.610,58.738,10.000},
				{5239.262,56.529,10.000},
				{5244.693,54.302,10.000},
				{5249.898,52.058,10.000},
				{5254.878,49.798,10.000},
				{5259.631,47.522,10.000},
				{5264.154,45.232,10.000},
				{5268.446,42.927,10.000},
				{5272.507,40.609,10.000},
				{5276.335,38.277,10.000},
				{5279.928,35.934,10.000},
				{5283.286,33.578,10.000},
				{5286.407,31.212,10.000},
				{5289.291,28.836,10.000},
				{5291.936,26.451,10.000},
				{5294.342,24.057,10.000},
				{5296.507,21.655,10.000},
				{5298.432,19.246,10.000},
				{5300.115,16.830,10.000},
				{5301.556,14.410,10.000},
				{5302.754,11.984,10.000},
				{5303.718,9.632,10.000},
				{5304.467,7.491,10.000},
				{5305.029,5.619,10.000},
				{5305.430,4.016,10.000},
				{5305.698,2.683,10.000},
				{5305.860,1.620,10.000},
				{5305.943,0.828,10.000},
				{5305.974,0.307,10.000},
				{5305.980,0.057,10.000},
				{5305.980,0.000,10.000}
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