package org.usfirst.frc.team319.paths;

import org.usfirst.frc.team319.models.SrxMotionProfile;
import org.usfirst.frc.team319.models.SrxTrajectory;

public class SameSideSwitch extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.75,0.00,0.00)
	// (12.08,1.42,0.00)
	// (15.42,-1.83,-89.00)
	
    public SameSideSwitch() {
		super();
		centerProfile = new SrxMotionProfile(centerPoints.length, centerPoints);
	}

	
    public SameSideSwitch(boolean flipped) {
		super();
		this.flipped = flipped;
		centerProfile = new SrxMotionProfile(centerPoints.length, centerPoints);
	}

	double[][] centerPoints = {
				{0.012,0.244,10.000,0.000},
				{0.061,0.488,10.000,0.000},
				{0.171,1.097,10.000,0.000},
				{0.366,1.951,10.000,0.000},
				{0.658,2.926,10.000,0.000},
				{1.048,3.901,10.000,0.000},
				{1.536,4.876,10.000,0.000},
				{2.121,5.850,10.000,0.000},
				{2.803,6.824,10.000,0.000},
				{3.583,7.797,10.000,0.000},
				{4.460,8.770,10.000,0.000},
				{5.434,9.743,10.000,0.000},
				{6.506,10.714,10.000,0.000},
				{7.674,11.685,10.000,0.001},
				{8.940,12.655,10.000,0.001},
				{10.302,13.625,10.000,0.001},
				{11.762,14.593,10.000,0.002},
				{13.318,15.560,10.000,0.002},
				{14.970,16.527,10.000,0.003},
				{16.719,17.492,10.000,0.003},
				{18.565,18.456,10.000,0.004},
				{20.507,19.418,10.000,0.005},
				{22.545,20.380,10.000,0.006},
				{24.679,21.340,10.000,0.007},
				{26.909,22.299,10.000,0.008},
				{29.234,23.256,10.000,0.010},
				{31.655,24.211,10.000,0.012},
				{34.172,25.165,10.000,0.014},
				{36.784,26.118,10.000,0.016},
				{39.491,27.069,10.000,0.018},
				{42.292,28.018,10.000,0.021},
				{45.189,28.965,10.000,0.024},
				{48.180,29.910,10.000,0.027},
				{51.265,30.854,10.000,0.031},
				{54.445,31.795,10.000,0.034},
				{57.718,32.735,10.000,0.039},
				{61.085,33.672,10.000,0.043},
				{64.546,34.607,10.000,0.048},
				{68.100,35.541,10.000,0.054},
				{71.747,36.472,10.000,0.060},
				{75.487,37.401,10.000,0.066},
				{79.320,38.327,10.000,0.073},
				{83.245,39.252,10.000,0.080},
				{87.263,40.174,10.000,0.088},
				{91.372,41.093,10.000,0.096},
				{95.573,42.011,10.000,0.105},
				{99.866,42.926,10.000,0.115},
				{104.249,43.838,10.000,0.125},
				{108.724,44.748,10.000,0.136},
				{113.290,45.656,10.000,0.147},
				{117.946,46.561,10.000,0.160},
				{122.692,47.463,10.000,0.173},
				{127.528,48.363,10.000,0.186},
				{132.454,49.260,10.000,0.201},
				{137.470,50.155,10.000,0.216},
				{142.575,51.047,10.000,0.232},
				{147.768,51.936,10.000,0.249},
				{153.051,52.823,10.000,0.267},
				{158.421,53.707,10.000,0.286},
				{163.880,54.589,10.000,0.305},
				{169.427,55.467,10.000,0.326},
				{175.061,56.344,10.000,0.347},
				{180.783,57.217,10.000,0.370},
				{186.592,58.088,10.000,0.394},
				{192.487,58.956,10.000,0.418},
				{198.469,59.821,10.000,0.444},
				{204.538,60.684,10.000,0.471},
				{210.692,61.544,10.000,0.499},
				{216.932,62.402,10.000,0.528},
				{223.258,63.256,10.000,0.558},
				{229.669,64.109,10.000,0.590},
				{236.165,64.958,10.000,0.623},
				{242.745,65.805,10.000,0.657},
				{249.410,66.649,10.000,0.692},
				{256.159,67.491,10.000,0.729},
				{262.992,68.331,10.000,0.767},
				{269.909,69.167,10.000,0.807},
				{276.909,70.002,10.000,0.848},
				{283.993,70.834,10.000,0.890},
				{291.159,71.663,10.000,0.934},
				{298.408,72.490,10.000,0.979},
				{305.739,73.315,10.000,1.025},
				{313.153,74.137,10.000,1.074},
				{320.649,74.957,10.000,1.123},
				{328.226,75.775,10.000,1.175},
				{335.886,76.591,10.000,1.227},
				{343.626,77.405,10.000,1.282},
				{351.448,78.217,10.000,1.338},
				{359.350,79.026,10.000,1.396},
				{367.334,79.834,10.000,1.455},
				{375.398,80.640,10.000,1.516},
				{383.542,81.444,10.000,1.579},
				{391.767,82.246,10.000,1.643},
				{400.072,83.047,10.000,1.709},
				{408.456,83.846,10.000,1.777},
				{416.920,84.643,10.000,1.847},
				{425.464,85.439,10.000,1.919},
				{434.088,86.234,10.000,1.992},
				{442.790,87.027,10.000,2.067},
				{451.572,87.819,10.000,2.144},
				{460.433,88.610,10.000,2.222},
				{469.373,89.400,10.000,2.303},
				{478.392,90.189,10.000,2.385},
				{487.490,90.977,10.000,2.470},
				{496.666,91.764,10.000,2.556},
				{505.921,92.551,10.000,2.644},
				{515.255,93.337,10.000,2.734},
				{524.667,94.123,10.000,2.825},
				{534.158,94.908,10.000,2.919},
				{543.727,95.693,10.000,3.014},
				{553.375,96.478,10.000,3.112},
				{563.101,97.263,10.000,3.211},
				{572.906,98.049,10.000,3.312},
				{582.790,98.834,10.000,3.415},
				{592.752,99.620,10.000,3.520},
				{602.792,100.406,10.000,3.627},
				{612.912,101.194,10.000,3.735},
				{623.110,101.981,10.000,3.846},
				{633.387,102.770,10.000,3.958},
				{643.743,103.560,10.000,4.072},
				{654.178,104.352,10.000,4.188},
				{664.692,105.144,10.000,4.306},
				{675.286,105.938,10.000,4.425},
				{685.960,106.734,10.000,4.547},
				{696.713,107.532,10.000,4.670},
				{707.546,108.331,10.000,4.795},
				{718.459,109.133,10.000,4.921},
				{729.453,109.937,10.000,5.050},
				{740.527,110.743,10.000,5.179},
				{751.682,111.553,10.000,5.311},
				{762.919,112.364,10.000,5.444},
				{774.237,113.179,10.000,5.579},
				{785.637,113.997,10.000,5.715},
				{797.118,114.819,10.000,5.853},
				{808.683,115.644,10.000,5.992},
				{820.330,116.472,10.000,6.133},
				{832.061,117.305,10.000,6.276},
				{843.875,118.141,10.000,6.419},
				{855.773,118.981,10.000,6.564},
				{867.755,119.826,10.000,6.710},
				{879.823,120.676,10.000,6.858},
				{891.976,121.530,10.000,7.006},
				{904.215,122.389,10.000,7.156},
				{916.540,123.253,10.000,7.307},
				{928.952,124.122,10.000,7.459},
				{941.452,124.997,10.000,7.612},
				{954.040,125.877,10.000,7.766},
				{966.716,126.763,10.000,7.921},
				{979.482,127.656,10.000,8.076},
				{992.337,128.554,10.000,8.233},
				{1005.283,129.458,10.000,8.390},
				{1018.320,130.369,10.000,8.547},
				{1031.448,131.286,10.000,8.706},
				{1044.669,132.211,10.000,8.865},
				{1057.984,133.142,10.000,9.024},
				{1071.392,134.080,10.000,9.183},
				{1084.894,135.025,10.000,9.343},
				{1098.492,135.978,10.000,9.503},
				{1112.186,136.939,10.000,9.664},
				{1125.977,137.907,10.000,9.824},
				{1139.865,138.883,10.000,9.984},
				{1153.852,139.867,10.000,10.145},
				{1167.937,140.859,10.000,10.305},
				{1182.123,141.859,10.000,10.464},
				{1196.410,142.867,10.000,10.624},
				{1210.798,143.885,10.000,10.783},
				{1225.289,144.910,10.000,10.942},
				{1239.884,145.944,10.000,11.100},
				{1254.583,146.988,10.000,11.257},
				{1269.387,148.040,10.000,11.414},
				{1284.297,149.101,10.000,11.569},
				{1299.314,150.171,10.000,11.724},
				{1314.439,151.250,10.000,11.878},
				{1329.673,152.339,10.000,12.031},
				{1345.016,153.437,10.000,12.182},
				{1360.471,154.544,10.000,12.332},
				{1376.037,155.661,10.000,12.481},
				{1391.716,156.787,10.000,12.628},
				{1407.508,157.923,10.000,12.774},
				{1423.415,159.069,10.000,12.918},
				{1439.437,160.224,10.000,13.060},
				{1455.576,161.389,10.000,13.200},
				{1471.832,162.564,10.000,13.339},
				{1488.207,163.748,10.000,13.475},
				{1504.702,164.943,10.000,13.609},
				{1521.316,166.147,10.000,13.741},
				{1538.052,167.361,10.000,13.870},
				{1554.911,168.585,10.000,13.997},
				{1571.893,169.819,10.000,14.122},
				{1588.999,171.062,10.000,14.244},
				{1606.230,172.315,10.000,14.363},
				{1623.588,173.579,10.000,14.479},
				{1641.074,174.852,10.000,14.592},
				{1658.687,176.135,10.000,14.703},
				{1676.430,177.427,10.000,14.810},
				{1694.303,178.730,10.000,14.913},
				{1712.307,180.042,10.000,15.014},
				{1730.443,181.363,10.000,15.111},
				{1748.713,182.695,10.000,15.205},
				{1767.116,184.036,10.000,15.295},
				{1785.643,185.270,10.000,15.381},
				{1804.271,186.278,10.000,15.463},
				{1822.977,187.060,10.000,15.541},
				{1841.738,187.612,10.000,15.615},
				{1860.543,188.050,10.000,15.685},
				{1879.392,188.490,10.000,15.750},
				{1898.285,188.932,10.000,15.811},
				{1917.223,189.377,10.000,15.867},
				{1936.205,189.823,10.000,15.919},
				{1955.232,190.271,10.000,15.967},
				{1974.305,190.721,10.000,16.010},
				{1993.422,191.172,10.000,16.049},
				{2012.584,191.624,10.000,16.083},
				{2031.792,192.078,10.000,16.113},
				{2051.045,192.532,10.000,16.138},
				{2070.344,192.988,10.000,16.158},
				{2089.688,193.444,10.000,16.175},
				{2109.078,193.900,10.000,16.186},
				{2128.514,194.357,10.000,16.193},
				{2147.995,194.814,10.000,16.196},
				{2167.522,195.271,10.000,16.194},
				{2187.095,195.728,10.000,16.188},
				{2206.714,196.185,10.000,16.177},
				{2226.378,196.642,10.000,16.161},
				{2246.088,197.098,10.000,16.141},
				{2265.843,197.553,10.000,16.117},
				{2285.644,198.008,10.000,16.088},
				{2305.490,198.462,10.000,16.055},
				{2325.381,198.914,10.000,16.017},
				{2345.318,199.365,10.000,15.974},
				{2365.300,199.815,10.000,15.927},
				{2385.326,200.264,10.000,15.876},
				{2405.397,200.710,10.000,15.820},
				{2425.513,201.155,10.000,15.760},
				{2445.672,201.598,10.000,15.696},
				{2465.876,202.038,10.000,15.627},
				{2486.124,202.477,10.000,15.554},
				{2506.415,202.912,10.000,15.476},
				{2526.750,203.345,10.000,15.395},
				{2547.127,203.775,10.000,15.309},
				{2567.547,204.202,10.000,15.218},
				{2588.010,204.625,10.000,15.124},
				{2608.514,205.045,10.000,15.025},
				{2629.060,205.462,10.000,14.923},
				{2649.648,205.874,10.000,14.816},
				{2670.276,206.282,10.000,14.705},
				{2690.945,206.687,10.000,14.590},
				{2711.653,207.086,10.000,14.472},
				{2732.401,207.481,10.000,14.349},
				{2753.188,207.871,10.000,14.222},
				{2774.014,208.256,10.000,14.092},
				{2794.878,208.635,10.000,13.958},
				{2815.778,209.009,10.000,13.820},
				{2836.716,209.377,10.000,13.679},
				{2857.690,209.739,10.000,13.534},
				{2878.699,210.094,10.000,13.385},
				{2899.744,210.443,10.000,13.233},
				{2920.822,210.785,10.000,13.078},
				{2941.934,211.120,10.000,12.919},
				{2963.079,211.447,10.000,12.757},
				{2984.256,211.767,10.000,12.592},
				{3005.464,212.079,10.000,12.424},
				{3026.702,212.383,10.000,12.253},
				{3047.970,212.679,10.000,12.079},
				{3069.266,212.966,10.000,11.902},
				{3090.591,213.244,10.000,11.722},
				{3111.942,213.513,10.000,11.540},
				{3133.319,213.772,10.000,11.355},
				{3154.721,214.021,10.000,11.167},
				{3176.147,214.261,10.000,10.978},
				{3197.596,214.490,10.000,10.786},
				{3219.067,214.709,10.000,10.591},
				{3240.559,214.916,10.000,10.395},
				{3262.070,215.113,10.000,10.197},
				{3283.600,215.299,10.000,9.997},
				{3305.147,215.472,10.000,9.795},
				{3326.711,215.634,10.000,9.592},
				{3348.289,215.784,10.000,9.387},
				{3369.881,215.921,10.000,9.181},
				{3391.486,216.046,10.000,8.973},
				{3413.102,216.158,10.000,8.765},
				{3434.727,216.257,10.000,8.555},
				{3456.362,216.343,10.000,8.345},
				{3478.003,216.415,10.000,8.134},
				{3499.650,216.473,10.000,7.922},
				{3521.302,216.517,10.000,7.710},
				{3542.957,216.547,10.000,7.498},
				{3564.613,216.563,10.000,7.285},
				{3586.270,216.564,10.000,7.073},
				{3607.925,216.550,10.000,6.860},
				{3629.577,216.522,10.000,6.648},
				{3651.225,216.478,10.000,6.437},
				{3672.867,216.419,10.000,6.226},
				{3694.501,216.345,10.000,6.015},
				{3716.126,216.255,10.000,5.806},
				{3737.741,216.149,10.000,5.597},
				{3759.344,216.027,10.000,5.390},
				{3780.933,215.890,10.000,5.184},
				{3802.507,215.736,10.000,4.980},
				{3824.063,215.566,10.000,4.777},
				{3845.601,215.380,10.000,4.576},
				{3867.119,215.177,10.000,4.377},
				{3888.615,214.958,10.000,4.181},
				{3910.087,214.722,10.000,3.987},
				{3931.534,214.469,10.000,3.795},
				{3952.954,214.200,10.000,3.606},
				{3974.345,213.914,10.000,3.419},
				{3995.706,213.610,10.000,3.236},
				{4017.035,213.290,10.000,3.056},
				{4038.331,212.952,10.000,2.879},
				{4059.590,212.598,10.000,2.706},
				{4080.813,212.225,10.000,2.536},
				{4101.996,211.836,10.000,2.370},
				{4123.139,211.429,10.000,2.209},
				{4144.240,211.005,10.000,2.051},
				{4165.296,210.563,10.000,1.898},
				{4186.306,210.103,10.000,1.749},
				{4207.269,209.626,10.000,1.605},
				{4228.182,209.130,10.000,1.466},
				{4249.044,208.617,10.000,1.332},
				{4269.852,208.086,10.000,1.204},
				{4290.606,207.536,10.000,1.081},
				{4311.303,206.968,10.000,0.963},
				{4331.941,206.381,10.000,0.851},
				{4352.518,205.776,10.000,0.745},
				{4373.034,205.152,10.000,0.646},
				{4393.485,204.509,10.000,0.552},
				{4413.869,203.847,10.000,0.466},
				{4434.186,203.166,10.000,0.386},
				{4454.432,202.465,10.000,0.313},
				{4474.607,201.744,10.000,0.247},
				{4494.707,201.003,10.000,0.188},
				{4514.731,200.242,10.000,0.137},
				{4534.677,199.460,10.000,0.094},
				{4554.543,198.657,10.000,0.058},
				{4574.326,197.833,10.000,0.031},
				{4594.025,196.987,10.000,0.012},
				{4613.637,196.120,10.000,0.002},
				{4633.172,195.351,10.000,359.999},
				{4652.786,196.136,10.000,359.989},
				{4672.525,197.393,10.000,359.966},
				{4692.389,198.639,10.000,359.931},
				{4712.377,199.879,10.000,359.883},
				{4732.488,201.114,10.000,359.824},
				{4752.723,202.347,10.000,359.752},
				{4773.081,203.579,10.000,359.668},
				{4793.562,204.814,10.000,359.571},
				{4814.168,206.054,10.000,359.463},
				{4834.897,207.300,10.000,359.342},
				{4855.753,208.555,10.000,359.209},
				{4876.735,209.821,10.000,359.063},
				{4897.845,211.100,10.000,358.904},
				{4919.085,212.395,10.000,358.733},
				{4940.455,213.708,10.000,358.549},
				{4961.959,215.041,10.000,358.351},
				{4983.599,216.395,10.000,358.140},
				{5005.376,217.775,10.000,357.916},
				{5027.295,219.181,10.000,357.677},
				{5049.356,220.617,10.000,357.425},
				{5071.565,222.084,10.000,357.158},
				{5093.923,223.585,10.000,356.876},
				{5116.435,225.123,10.000,356.578},
				{5139.105,226.700,10.000,356.266},
				{5161.937,228.319,10.000,355.937},
				{5184.936,229.983,10.000,355.591},
				{5208.105,231.693,10.000,355.229},
				{5231.450,233.454,10.000,354.850},
				{5254.977,235.267,10.000,354.452},
				{5278.691,237.136,10.000,354.036},
				{5302.597,239.064,10.000,353.601},
				{5326.702,241.053,10.000,353.146},
				{5351.013,243.105,10.000,352.671},
				{5375.535,245.225,10.000,352.175},
				{5400.277,247.414,10.000,351.657},
				{5425.244,249.676,10.000,351.117},
				{5450.446,252.012,10.000,350.554},
				{5475.888,254.425,10.000,349.967},
				{5501.568,256.800,10.000,349.355},
				{5527.465,258.971,10.000,348.719},
				{5553.554,260.882,10.000,348.059},
				{5579.806,262.520,10.000,347.375},
				{5606.205,263.991,10.000,346.667},
				{5632.750,265.456,10.000,345.934},
				{5659.446,266.954,10.000,345.178},
				{5686.294,268.483,10.000,344.396},
				{5713.298,270.037,10.000,343.590},
				{5740.459,271.612,10.000,342.758},
				{5767.779,273.200,10.000,341.901},
				{5795.258,274.794,10.000,341.018},
				{5822.897,276.387,10.000,340.111},
				{5850.694,277.968,10.000,339.177},
				{5878.646,279.527,10.000,338.219},
				{5906.752,281.052,10.000,337.236},
				{5935.005,282.533,10.000,336.229},
				{5963.400,283.955,10.000,335.198},
				{5991.931,285.304,10.000,334.144},
				{6020.588,286.567,10.000,333.067},
				{6049.360,287.727,10.000,331.970},
				{6078.237,288.771,10.000,330.853},
				{6107.206,289.682,10.000,329.717},
				{6136.250,290.445,10.000,328.564},
				{6165.355,291.046,10.000,327.395},
				{6194.502,291.472,10.000,326.212},
				{6223.673,291.709,10.000,325.018},
				{6252.847,291.745,10.000,323.813},
				{6282.005,291.573,10.000,322.600},
				{6311.123,291.183,10.000,321.382},
				{6340.180,290.569,10.000,320.160},
				{6369.153,289.730,10.000,318.937},
				{6398.019,288.662,10.000,317.715},
				{6426.756,287.368,10.000,316.495},
				{6455.341,285.851,10.000,315.281},
				{6483.753,284.117,10.000,314.075},
				{6511.970,282.174,10.000,312.878},
				{6539.973,280.032,10.000,311.693},
				{6567.743,277.701,10.000,310.521},
				{6595.263,275.196,10.000,309.364},
				{6622.516,272.530,10.000,308.225},
				{6649.488,269.717,10.000,307.103},
				{6676.165,266.774,10.000,306.000},
				{6702.537,263.716,10.000,304.919},
				{6728.593,260.559,10.000,303.859},
				{6754.324,257.317,10.000,302.821},
				{6779.725,254.005,10.000,301.806},
				{6804.789,250.639,10.000,300.815},
				{6829.512,247.231,10.000,299.848},
				{6853.891,243.795,10.000,298.906},
				{6877.925,240.341,10.000,297.988},
				{6901.614,236.881,10.000,297.094},
				{6924.956,233.424,10.000,296.226},
				{6947.954,229.980,10.000,295.381},
				{6970.610,226.555,10.000,294.561},
				{6992.925,223.157,10.000,293.765},
				{7014.904,219.792,10.000,292.992},
				{7036.551,216.464,10.000,292.243},
				{7057.869,213.178,10.000,291.516},
				{7078.862,209.938,10.000,290.812},
				{7099.537,206.746,10.000,290.130},
				{7119.897,203.604,10.000,289.470},
				{7139.949,200.515,10.000,288.830},
				{7159.697,197.480,10.000,288.210},
				{7179.147,194.499,10.000,287.611},
				{7198.304,191.573,10.000,287.031},
				{7217.174,188.702,10.000,286.469},
				{7235.763,185.887,10.000,285.926},
				{7254.076,183.125,10.000,285.400},
				{7272.117,180.417,10.000,284.892},
				{7289.894,177.763,10.000,284.400},
				{7307.410,175.161,10.000,283.924},
				{7324.671,172.610,10.000,283.464},
				{7341.682,170.108,10.000,283.019},
				{7358.447,167.656,10.000,282.588},
				{7374.972,165.252,10.000,282.172},
				{7391.262,162.893,10.000,281.769},
				{7407.320,160.580,10.000,281.380},
				{7423.151,158.310,10.000,281.003},
				{7438.759,156.083,10.000,280.639},
				{7454.148,153.896,10.000,280.287},
				{7469.323,151.749,10.000,279.946},
				{7484.287,149.641,10.000,279.616},
				{7499.044,147.569,10.000,279.298},
				{7513.598,145.533,10.000,278.990},
				{7527.951,143.532,10.000,278.692},
				{7542.107,141.564,10.000,278.404},
				{7556.070,139.629,10.000,278.125},
				{7569.843,137.724,10.000,277.855},
				{7583.428,135.849,10.000,277.595},
				{7596.828,134.004,10.000,277.343},
				{7610.047,132.186,10.000,277.099},
				{7623.086,130.394,10.000,276.864},
				{7635.949,128.629,10.000,276.636},
				{7648.638,126.889,10.000,276.416},
				{7661.155,125.172,10.000,276.203},
				{7673.503,123.479,10.000,275.997},
				{7685.684,121.809,10.000,275.798},
				{7697.700,120.160,10.000,275.606},
				{7709.553,118.531,10.000,275.420},
				{7721.245,116.923,10.000,275.241},
				{7732.779,115.334,10.000,275.068},
				{7744.155,113.764,10.000,274.900},
				{7755.376,112.212,10.000,274.738},
				{7766.444,110.678,10.000,274.582},
				{7777.360,109.160,10.000,274.431},
				{7788.126,107.659,10.000,274.285},
				{7798.743,106.173,10.000,274.145},
				{7809.214,104.703,10.000,274.009},
				{7819.538,103.247,10.000,273.878},
				{7829.719,101.806,10.000,273.751},
				{7839.757,100.379,10.000,273.630},
				{7849.653,98.965,10.000,273.512},
				{7859.410,97.564,10.000,273.399},
				{7869.027,96.175,10.000,273.289},
				{7878.507,94.799,10.000,273.184},
				{7887.850,93.434,10.000,273.082},
				{7897.059,92.081,10.000,272.985},
				{7906.132,90.739,10.000,272.891},
				{7915.073,89.408,10.000,272.800},
				{7923.882,88.087,10.000,272.713},
				{7932.560,86.776,10.000,272.629},
				{7941.107,85.476,10.000,272.548},
				{7949.526,84.185,10.000,272.471},
				{7957.816,82.903,10.000,272.396},
				{7965.979,81.630,10.000,272.325},
				{7974.016,80.367,10.000,272.256},
				{7981.927,79.111,10.000,272.190},
				{7989.713,77.865,10.000,272.127},
				{7997.376,76.626,10.000,272.066},
				{8004.915,75.396,10.000,272.008},
				{8012.333,74.173,10.000,271.952},
				{8019.628,72.958,10.000,271.899},
				{8026.803,71.750,10.000,271.848},
				{8033.858,70.550,10.000,271.799},
				{8040.794,69.356,10.000,271.752},
				{8047.611,68.170,10.000,271.708},
				{8054.310,66.990,10.000,271.665},
				{8060.892,65.817,10.000,271.625},
				{8067.357,64.650,10.000,271.586},
				{8073.706,63.489,10.000,271.549},
				{8079.939,62.335,10.000,271.514},
				{8086.058,61.187,10.000,271.481},
				{8092.062,60.044,10.000,271.449},
				{8097.953,58.907,10.000,271.419},
				{8103.731,57.776,10.000,271.391},
				{8109.396,56.651,10.000,271.363},
				{8114.949,55.530,10.000,271.338},
				{8120.390,54.415,10.000,271.314},
				{8125.721,53.306,10.000,271.291},
				{8130.941,52.201,10.000,271.269},
				{8136.051,51.101,10.000,271.249},
				{8141.052,50.006,10.000,271.229},
				{8145.943,48.916,10.000,271.211},
				{8150.726,47.830,10.000,271.194},
				{8155.401,46.749,10.000,271.178},
				{8159.968,45.672,10.000,271.163},
				{8164.428,44.600,10.000,271.149},
				{8168.781,43.532,10.000,271.136},
				{8173.028,42.467,10.000,271.124},
				{8177.169,41.407,10.000,271.113},
				{8181.204,40.351,10.000,271.102},
				{8185.134,39.299,10.000,271.092},
				{8188.959,38.251,10.000,271.083},
				{8192.680,37.206,10.000,271.075},
				{8196.296,36.164,10.000,271.067},
				{8199.809,35.127,10.000,271.060},
				{8203.218,34.092,10.000,271.053},
				{8206.524,33.061,10.000,271.047},
				{8209.727,32.033,10.000,271.042},
				{8212.828,31.008,10.000,271.037},
				{8215.827,29.986,10.000,271.032},
				{8218.723,28.967,10.000,271.028},
				{8221.519,27.951,10.000,271.024},
				{8224.212,26.938,10.000,271.021},
				{8226.805,25.927,10.000,271.018},
				{8229.297,24.919,10.000,271.016},
				{8231.688,23.913,10.000,271.013},
				{8233.979,22.910,10.000,271.011},
				{8236.170,21.909,10.000,271.009},
				{8238.261,20.910,10.000,271.008},
				{8240.252,19.913,10.000,271.006},
				{8242.144,18.918,10.000,271.005},
				{8243.937,17.925,10.000,271.004},
				{8245.630,16.934,10.000,271.003},
				{8247.225,15.945,10.000,271.003},
				{8248.720,14.957,10.000,271.002},
				{8250.118,13.971,10.000,271.002},
				{8251.416,12.986,10.000,271.001},
				{8252.616,12.002,10.000,271.001},
				{8253.718,11.020,10.000,271.001},
				{8254.722,10.039,10.000,271.000},
				{8255.628,9.058,10.000,271.000},
				{8256.436,8.079,10.000,271.000},
				{8257.146,7.101,10.000,271.000},
				{8257.758,6.123,10.000,271.000},
				{8258.273,5.146,10.000,271.000},
				{8258.690,4.169,10.000,271.000},
				{8259.009,3.193,10.000,271.000},
				{8259.231,2.217,10.000,271.000},
				{8259.364,1.330,10.000,271.000},
				{8259.429,0.654,10.000,271.000},
				{8259.452,0.222,10.000,271.000},
				{8259.455,0.033,10.000,271.000},
				{8259.455,0.000,10.000,271.000}		};

}